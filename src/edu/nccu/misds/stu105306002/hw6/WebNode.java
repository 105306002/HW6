package edu.nccu.misds.stu105306002.hw6;

import java.io.IOException;
import java.util.ArrayList;

public class WebNode
{
	public WebNode parent;
	public ArrayList<WebNode> children;
	public WebPage webPage;
	public double nodeScore;
	
	
	public WebNode(WebPage webPage)
	{
		this.webPage = webPage;
		this.children = new ArrayList<WebNode>();
		
	}
	
	public void setNodeScore(ArrayList<Keyword> keyowrds) throws IOException
	{
		webPage.setScore(keyowrds);
		nodeScore = webPage.score;
		
		for(WebNode child : children)
		{
			nodeScore += child.nodeScore;
		}	
}
	
	
	public void addChild(WebNode child) 
	{
		this.children.add(child);
		child.parent = this;
		
	}
	
	public boolean isTheLastChild()
	{
		if(this.parent == null) return true;
		
		ArrayList<WebNode> siblings = this.parent.children;
		
		return this.equals(siblings.get(siblings.size()-1));
				
	}
	
	public int getDepth()
	{
		int retVal = 1;
		WebNode currentNode = this;
		while(currentNode.parent != null)
		{
			retVal++;
			currentNode = currentNode.parent;
		}
		return retVal;
	}
	
	
	
	
	
}
