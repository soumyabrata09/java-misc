package com.sam09.Exercises;

/*
 * @author Soumyabrata
 *
 */
public class ObjectCloning implements Cloneable{

	private String expression ="Object cloning is done !!!";
	
	@Override
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
		
	}
	
	/**
	 * @return the expression
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * @param expression the expression to set
	 */
	public void setExpression(String expression) {
		this.expression = expression;
	}

	public static void main(String[] args) {
		try {
			//object creation through newInstance() invocation
			ObjectCloning obj1 = (ObjectCloning)Class.forName("com.sample.ObjectCloning").newInstance();
			ObjectCloning obj2 = (ObjectCloning) obj1.clone();
			System.out.println(obj2.getExpression());
			
		} catch (InstantiationException  | IllegalAccessException  | ClassNotFoundException | CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
