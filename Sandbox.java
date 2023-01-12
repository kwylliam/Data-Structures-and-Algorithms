/*
 * Sandbox.java
 * 
 * Copyright 2020 William Kamau <wyll@Wyll-PC>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */

import java.util.*;
public class Sandbox {
	
	public static void main (String[] args) {
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter coordinates");
	String a=sc.nextLine();
	int j= int(a.charAt(0));
	

	System.out.println(j);
	}
	private static int hash(String s, int end){
		int count=0;
		for(int i=0; i<=end; i++){
			if (s.charAt(i)== '#'){
				count++;
				}
			}
		return count;
		}
}


