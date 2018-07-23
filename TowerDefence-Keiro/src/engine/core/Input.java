package engine.core;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Input 
{
	private static ArrayList<Integer> currentKeys = new ArrayList<Integer>();
	private static ArrayList<Integer> downKeys = new ArrayList<Integer>();
	private static ArrayList<Integer> upKeys = new ArrayList<Integer>();
	
	private static ArrayList<Integer> currentMouse = new ArrayList<Integer>();
	private static ArrayList<Integer> downMouse = new ArrayList<Integer>();
	private static ArrayList<Integer> upMouse = new ArrayList<Integer>();
	
	public static final int NUM_KEYS = 256;
	public static final int NUM_MOUSEBUTTONS = 3;
	
	public static void update()
	{
		upMouse.clear();
		for(int i = 0; i != NUM_MOUSEBUTTONS; i++)
			if(!mouseDown(i) && currentMouse.contains(i))
				upMouse.add(i);
		
		downMouse.clear();
		for(int i = 0; i != NUM_MOUSEBUTTONS; i++)
			if(mouseDown(i) && !currentMouse.contains(i))
				downMouse.add(i);
		
		upKeys.clear();
		for(int i = 0; i != NUM_KEYS; i++)
			if(!keyDown(i) && currentKeys.contains(i))
				upKeys.add(i);
		
		downKeys.clear();
		for(int i = 0; i != NUM_KEYS; i++)
			if(keyDown(i) && !currentKeys.contains(i))
				downKeys.add(i);
		
		currentKeys.clear();
		for(int i = 0; i != NUM_KEYS; i++)
			if(keyDown(i))
				currentKeys.add(i);
		
		currentMouse.clear();
		for(int i = 0; i != NUM_MOUSEBUTTONS; i++)
			if(mouseDown(i))
				currentMouse.add(i);
		
	}
	
	public static boolean keyDown(int keyCode)
	{
		return Keyboard.isKeyDown(keyCode);
	}
	
	public static boolean keyPressed(int keyCode)
	{
		return downKeys.contains(keyCode);
	}
	
	public static boolean keyUp(int keyCode)
	{
		return upKeys.contains(keyCode);
	}
	
	public static boolean mouseDown(int mouseButton)
	{
		return Mouse.isButtonDown(mouseButton);
	}
	
	public static boolean mouseButtonPressed(int mouseButton)
	{
		return downMouse.contains(mouseButton);
	}
	
	public static boolean mouseButtonReleased(int mouseButton)
	{
		return upMouse.contains(mouseButton);
	}
	
	public static Vector2f mousePosition()
	{
		return new Vector2f(Mouse.getX(), Mouse.getY());
	}
}
