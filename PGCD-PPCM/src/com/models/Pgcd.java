package com.models;

public class Pgcd {
	private int entier1 ;
	private int entier2 ;
	
	public Pgcd() {
	    this.entier1=0;
	    this.entier2=0;	
	}

	public Pgcd(int entier1, int entier2) {
		super();
		this.entier1 = entier1;
		this.entier2 = entier2;
	}

	public int getEntier1() {
		return entier1;
	}
	
	public void setEntier1(int entier1) {
		this.entier1 = entier1;
	}
	
	public int getEntier2() {
		return entier2;
	}
	
	public void setEntier2(int entier2) {
		this.entier2 = entier2;
	}

	public int calculatePgcd(int a, int b)

	{
		int m = a;
		int n = b;

		while (m != n)

		{

			if (m > n) {

				m = m - n;
			} else {

				n = n - m;

			}
		}
		return m;
	}
	
	

 }
