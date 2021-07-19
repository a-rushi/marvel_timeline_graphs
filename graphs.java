
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Vector;
public class assignment4{
	Graph graph;
	assignment4(int i){
		this.graph= new Graph(i);
	}
public class Graph {
	 int vertices;
	public Map<Integer,Node> nodemap;
     LinkedList<Edge> [] adjlist;
     Graph(int vertices) {
         this.vertices = vertices;
         adjlist = new LinkedList[vertices];

    	 nodemap = new HashMap<>();
         //initialize adjacency lists for all the vertices
     
         for (int i = 0; i <vertices ; i++) {
             adjlist[i] = new LinkedList<>();
         }
     }
     public void addEdge(Node source, Node destination, int weight) {
         Edge edge = new Edge(source, destination, weight);
         adjlist[source.id].addFirst(edge); 
         source.setSum(source.getSum()+edge.getLength());
         destination.setSum(destination.getSum()+edge.getLength());
         adjlist[destination.id].addFirst(edge);
     }
     public float average() {
    	 float avg=0;
    	 int i=0;
    	 for(i=0;i<vertices;i++) {
    	 for(Edge in : adjlist[i]) {
    		 avg=avg+1;
    	 }
    	 }
    	 avg=avg/vertices;
    	
    	 //float roundOff = (float) (Math.round(avg * 100.0) / 100.0);
    	 return avg;
     }
    void sort2(Vector<Vector<Node>>n,int l, int r) {
 if (l < r) {
             
             int m = (l + r) / 2;
  
             
             sort2(n, l, m);
             sort2(n, m + 1, r);
  
           
             int n1 = m - l + 1;
             int n2 = r - m;
      
          Vector<Vector<Node>>L= new Vector<Vector<Node>>();
          Vector<Vector<Node>>R= new Vector<Vector<Node>>();
          L.setSize(n1);
          R.setSize(n2);
          for (int i = 0; i < n1; ++i)
                 L.set(i, n.get(l+i));
             for (int j = 0; j < n2; ++j)
                 R.set(j,n.get(m + 1 + j));
      
      
             int i = 0, j = 0;
      
             int k = l;
             while (i < n1 && j < n2) {
                 if (L.get(i).size()-R.get(j).size()<0) {
                	 n.set(k, R.get(j));
                	// System.out.println(R.get(j).size()+"size");
                     j++;
                     
                 }
                 else if(L.get(i).size()-R.get(j).size()==0){
                	 sort(L.get(i),0,L.get(i).size()-1);
                	 sort(R.get(j),0,R.get(j).size()-1); 
                	// System.out.print("loop");
//                	 if(R.get(j).size()==0) {
//                		 System.out.print("both null vectors");
//                		 i++;
//                		 j++;
//                	 }
                	// else {
                		 if(R.get(j).get(0).getLabel().compareTo(L.get(i).get(0).getLabel())<=0){
                		 n.set(k,L.get(i));
                         i++;
                	 }
                	 
                	 else {
                		 n.set(k, R.get(j));
                         j++;
                         }
                 }
                // }
                 else {
                    n.set(k,L.get(i));
                     i++;
                   //  System.out.println(L.get(i).size()+"size");
                 }
                 k++;
             }
      
             while (i < n1) {
            	 n.set(k,L.get(i));
                 i++;
                 k++;
             }
      
             while (j < n2) {
            	 n.set(k, R.get(j));
                 j++;
                 k++;
             }
      
             
         }
  
    }
     void sort(Vector<Node> n,int l,int r) {
    	 if (l < r) {
             
             int m = (l + r) / 2;
  
             
             sort(n, l, m);
             sort(n, m + 1, r);
  
           
             int n1 = m - l + 1;
             int n2 = r - m;
      
             Node L[] = new Node[n1];
             Node R[] = new Node[n2];
      
             for (int i = 0; i < n1; ++i)
                 L[i] = n.get(l + i);
             for (int j = 0; j < n2; ++j)
                 R[j] = n.get(m + 1 + j);
      
      
             int i = 0, j = 0;
      
             int k = l;
             while (i < n1 && j < n2) {
                 if (L[i].getLabel().compareTo(R[j].getLabel())<=0) {
                	 n.set(k, R[j]);
                     j++;
                     
                 }
                
                 else {
                    n.set(k,L[i]);
                     i++;
                 }
                 k++;
             }
      
             while (i < n1) {
            	 n.set(k,L[i]);
                 i++;
                 k++;
             }
      
             while (j < n2) {
            	 n.set(k, R[j]);
                 j++;
                 k++;
             }
      
             
         }
  
     }
       void sort(ArrayList<Node> n, int l, int r)
     {
         if (l < r) {
            
             int m = (l + r) / 2;
  
             
             sort(n, l, m);
             sort(n, m + 1, r);
  
           
             int n1 = m - l + 1;
             int n2 = r - m;
      
             Node L[] = new Node[n1];
             Node R[] = new Node[n2];
      
             for (int i = 0; i < n1; ++i)
                 L[i] = n.get(l + i);
             for (int j = 0; j < n2; ++j)
                 R[j] = n.get(m + 1 + j);
      
      
             int i = 0, j = 0;
      
             int k = l;
             while (i < n1 && j < n2) {
                 if (L[i].getSum() > R[j].getSum()) {
                	 n.set(k, R[j]);
                     j++;
                     
                 }
                 else if(L[i].getSum()==R[j].getSum()) {
                	 if(L[i].getLabel().compareTo(R[j].getLabel())>=0) {
                		 n.set(k, R[j]);
                		 j++;
                		
                	 }
                	 else {
                		 n.set(k, L[i]);
                		 i++;
                		
                	 }
                 }
                 else {
                    n.set(k,L[i]);
                     i++;
                 }
                 k++;
             }
      
             while (i < n1) {
            	 n.set(k,L[i]);
                 i++;
                 k++;
             }
      
             while (j < n2) {
            	 n.set(k, R[j]);
                 j++;
                 k++;
             }
      
             
         }
     }
    public void rank() {
    	  ArrayList<Node> n = new ArrayList<Node>(nodemap.values()); 
    	 sort(n,0,n.size()-1);
  for(int i=n.size()-1;i>=0;i--) {
	  if(i==n.size()-1) {
		  System.out.print(n.get(n.size()-1).label);
	  }
	  else {
  System.out.print(","+n.get(i).label);
	  }
  }
  return;
     }
    public void indep_story() {
    	 ArrayList<Node> n = new ArrayList<Node>(nodemap.values()); 
    	// sort(n,0,n.size()-1);
    	 Vector<Vector<Node>> indep=new Vector<Vector<Node>>();
    	 for(Node i : n) {
    		 if(i.color=="w") {
    			 Vector<Node>v= new Vector<Node>() ;
    			 v.add(i);
    		indep.add(BFS(i,v));
    		}
    		 //if(indep.elementAt(i.getId())!=null) {
    			// System.out.print(indep.elementAt(i.getId()).toString());
    		 //}
    		 }
    	 sort2(indep,0,indep.size()-1);
    	 for(Vector<Node> k : indep) {
    		sort(k, 0, k.size()-1);
    		int m=0;
    		 for(Node j :k) {
    			 if(m==0) {
    			 System.out.print(j.getLabel());
    			 m++;
    			 }
    			 else {
    				 System.out.print(","+j.getLabel());
    				 
    			 }
    			
    		 }
    		 System.out.println();
    	 }
    	 return;
    }
    public Vector<Node> BFS(Node i, Vector<Node> in){
    	//v is white and unvisited
    	i.setColor("b");
    	if((adjlist[i.getId()]!=null)) {
    	for(Edge e : adjlist[i.getId()]) {
    		if(e.target!=i) {
    		if(e.target.color=="w") {
    			in.add(e.target);
        		BFS(e.target,in);
    			}
    		}
    		else {
    			if(e.source.color=="w") {
        			in.add(e.source);
            		BFS(e.source,in);
        			}
    		}
    	}
    	}
    	return in;
    }
    
}
public static class Edge{
	private int length;
	private Node target;
	private Node source;
	
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Node getTarget() {
		return target;
	}
	public void setTarget(Node target) {
		this.target = target;
	}
	public Node getSource() {
		return source;
	}
	public void setSource(Node source) {
		this.source = source;
	}
	Edge(Node s,Node t,int len){
		
		this.target=t;
		this.source=s;
		this.length=len;
	}
}
public static class Node{
	private String label;
	private int id;
	private int sum;
	private String color;
	public Node(String label,int id){
		this.setId(id);
		label=label.replace("\"", "");
		this.setLabel(label);
		this.sum=0;
		this.setColor("w");
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}

public static void main(String[] args) throws Exception  {
	
	// TODO Auto-generated method stub
	//Scanner sc=new Scanner(System.in);
	String node= //sc.next();
			args[0];
	String edges= //sc.next();
	args[1];
	String function=//sc.next();
	args[2];
	//ArrayList<String> ar = new ArrayList<String>();
	 Map<String,Integer> map = new HashMap<>();
	
//LinkedList<String> nodes= new LinkedList<String>();
	File csvFile = new File(node);
	BufferedReader br = new BufferedReader(new FileReader(csvFile));
	String line = "";
	int lineNumber = -1;
	while ((line = br.readLine()) != null) {
		if(lineNumber!=-1) {
			//line.replaceAll("\"", "");
	String[] arr = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
	//System.out.println(arr[0]); 
	//nodes.add(arr[0]);
	map.put(arr[0],lineNumber);
		}
	// System.out.println("arr[1] = " + arr[1]); // Vito
	lineNumber++;
	//input command /Users/aditijain/Downloads/nodes.csv /Users/aditijain/Downloads/edges.csv average
	// /Users/aditijain/eclipse-workspace/Assignment4/src/nodes.csv /Users/aditijain/eclipse-workspace/Assignment4/src/edges.csv independent_storylines_dfs
	//   /Users/aditijain/Downloads/nodes.csv /Users/aditijain/Downloads/edges.csv independent_storylines_dfs
	// /Users/aditijain/Downloads/COL106Assignment4Checker-main/dfsGeneratedNodes.csv /Users/aditijain/Downloads/COL106Assignment4Checker-main/dfsGeneratedEdges.csv independent_storylines_dfs
	}
	//System.out.println(lineNumber); 
	assignment4 obj= new assignment4(lineNumber);
	Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
	while (it.hasNext()) {
		 Entry<String, Integer> i = it.next();
		Node n= new Node(i.getKey(),i.getValue());
		obj.graph.nodemap.put(n.id, n);
	}
	File csv1File = new File(edges);
	BufferedReader br1 = new BufferedReader(new FileReader(csv1File));
	String line1 = "";
	int lineNum=-1;
	
	while((line1=br1.readLine())!=null) {
		if(lineNum!=-1) {
		//line1.replace("\"", "");
		//	String[] arr1=line1.split("@\",(?=(?:[^\"\"]*\"\"[^\"\"]*\"\")*(?![^\"\"]*\"\"))\"");
			//line1.replaceAll("\"", "");
			String[] arr1=line1.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			Node src ;
			Node tar;
		//	if(obj.graph.nodemap.containsKey(map.get(arr1[0]))==false) {
		//		 src= new Node(arr1[0],map.get(arr1[0]));
		//	obj.graph.nodemap.put(src.id,src);
		//	}
		//	if(obj.graph.nodemap.containsKey(map.get(arr1[0]))==true) {
				src=obj.graph.nodemap.get(map.get(arr1[0]));
		//	}
		//	if(obj.graph.nodemap.containsKey(map.get(arr1[1]))==false){
		//		tar= new Node(arr1[1],map.get(arr1[1]));
		//	obj.graph.nodemap.put(tar.id,tar);
		//}
		//	if(obj.graph.nodemap.containsKey(map.get(arr1[1]))==true) {
				 tar=obj.graph.nodemap.get(map.get(arr1[1]));
		//	}
			int len=Integer.valueOf(arr1[2]);
			obj.graph.addEdge(src,tar,len);
			
		
			
		}
		lineNum++;
	}
	switch(function) {
	case "average":
		System.out.println(String.format("%.2f",obj.graph.average()));
		
		break;
	case "rank":
		obj.graph.rank();
		//for (int k=1;k<=obj.graph.nodemap.size();k++) {
		//	System.out.println(obj.graph.nodemap.get(k).sum+" , "+ obj.graph.nodemap.get(k).label);
		 //}
	           
		break;
	case"independent_storylines_dfs":
		obj.graph.indep_story();
		break;
	default:
		break;
	}
}
}



