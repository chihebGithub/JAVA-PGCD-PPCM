package com.models;

public class Ppcm {
	
	private int entier1;
	private int entier2;
	
	
	
	public Ppcm() {
	  this.entier1=0;
	  this.entier2=0;
	}
	
	public Ppcm(int entier1, int entier2) {
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
	
	public int calculatePpcm(int a, int b) {

		int m = a;

		int n = b;

		int prod, reste, res;

		prod = n * m;

		reste = n % m;

		while (reste != 0) {

			n = m;

			m = reste;

			reste = n % m;

		}

		res = prod / m;

		return (res);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
