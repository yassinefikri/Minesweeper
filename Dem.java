import java.util.Scanner; 
public class Dem {
	private Case[][] m;
	private int NbrCres;
	Scanner sc = new Scanner(System.in);
	public Dem(){
		m=new Case[10][10];
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				m[i][j]=new Case();
			}
		}
	}
	public Case getm(int i,int j){return m[i][j];};
	public void setPlan() {
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				m[i][j].setv(0);
				m[i][j].setc(1);
			}
		}
		// MINE 1
		int a;
		int b;
		a=(int)(Math.random()*10);
		b=(int)(Math.random()*10);
		m[a][b].setv(-1);
	
		// Mine 2 and 3
		for(int i=0;i<2;i++) {
				do {
					a=(int)(Math.random()*10);
					b=(int)(Math.random()*10);
				}while(m[a][b].getv()==-1);
				m[a][b].setv(-1);
		}

		//Mines Voisines
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(m[i][j].getv()==-1) {
					for(int k=0;k<2;k++) {
						do {
							do {
								a=(int)(Math.random()*8-4);
								b=(int)(Math.random()*8-4);
							}while(a+i>9 || a+i<0 || b+j>9 || b+j<0);
						}while(m[i+a][j+b].getv()==-1 || m[i+a][j+b].getv()==-2);
						m[i+a][j+b].setv(-2);
					}
				}
			}
		}
		//1 More Mine
		do {
			a=(int)(Math.random()*10);
			b=(int)(Math.random()*10);
		}while (m[a][b].getv()==-1 || m[a][b].getv()==-2);
		m[a][b].setv(-2);
		
		//1 last MINE
		do {
			a=(int)(Math.random()*10);
			b=(int)(Math.random()*10);
		}while (m[a][b].getv()==-1 || m[a][b].getv()==-2);
		m[a][b].setv(-2);
		
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(m[i][j].getv()==0) {
				if(i!=0 && i!=9 && j!=0 && j!=9) {
					int r=0;
					for(int k=-1;k<2;k++) {
						for(int l=-1;l<2;l++) {
							if(k!=0 || l!=0) {
								if(m[i+k][j+l].getv()==-1 || m[i+k][j+l].getv()==-2) r++;
							}
						}
					}
					m[i][j].setv(r);
				}
				if(i==0 && j!=0 && j!=9) {
					int r=0;
					for(int k=0;k<2;k++) {
						for(int l=-1;l<2;l++) {
							if(k!=0 || l!=0) {
								if(m[i+k][j+l].getv()==-1 || m[i+k][j+l].getv()==-2) r++;
							}
						}
					}
					m[i][j].setv(r);
				}
				if(i==9 && j!=0 && j!=9) {
					int r=0;
					for(int k=-1;k<1;k++) {
						for(int l=-1;l<2;l++) {
							if(k!=0 || l!=0) {
								if(m[i+k][j+l].getv()==-1 || m[i+k][j+l].getv()==-2) r++;
							}
						}
					}
					m[i][j].setv(r);
				}
				if(j==0 && i!=0 && i!=9) {
					int r=0;
					for(int k=-1;k<2;k++) {
						for(int l=0;l<2;l++) {
							if(k!=0 || l!=0) {
								if(m[i+k][j+l].getv()==-1 || m[i+k][j+l].getv()==-2) r++;
							}
						}
					}
					m[i][j].setv(r);
				}
				if(j==9 && i!=0 && i!=9) {
					int r=0;
					for(int k=-1;k<2;k++) {
						for(int l=-1;l<1;l++) {
							if(k!=0 || l!=0) {
								if(m[i+k][j+l].getv()==-1 || m[i+k][j+l].getv()==-2) r++;
							}
						}
					}
					m[i][j].setv(r);
				}
				if(i==0 && j==0) {
					int r=0;
					for(int k=0;k<2;k++) {
						for(int l=0;l<2;l++) {
							if(k!=0 || l!=0) {
								if(m[i+k][j+l].getv()==-1 || m[i+k][j+l].getv()==-2) r++;
							}
						}
					}
					m[i][j].setv(r);
				}
				if(i==0 && j==9) {
					int r=0;
					for(int k=0;k<2;k++) {
						for(int l=-1;l<1;l++) {
							if(k!=0 || l!=0) {
								if(m[i+k][j+l].getv()==-1 || m[i+k][j+l].getv()==-2) r++;
							}
						}
					}
					m[i][j].setv(r);
				}
				if(i==9 && j==0) {
					int r=0;
					for(int k=-1;k<1;k++) {
						for(int l=0;l<2;l++) {
							if(k!=0 || l!=0) {
								if(m[i+k][j+l].getv()==-1 || m[i+k][j+l].getv()==-2) r++;
							}
						}
					}
					m[i][j].setv(r);
				}
				if(i==9 && j==9) {
					int r=0;
					for(int k=-1;k<1;k++) {
						for(int l=-1;l<1;l++) {
							if(k!=0 || l!=0) {
								if(m[i+k][j+l].getv()==-1 || m[i+k][j+l].getv()==-2) r++;
							}
						}
					}
					m[i][j].setv(r);
				}
				}
			}
		}
			
	}
	
	/*public void afficher() {
		String ch="";
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(m[i][j].getc()==0) {
					if(m[i][j].getv()==0) ch+=". ";
					else if(m[i][j].getv()<0) ch+="* ";
					else ch+=m[i][j].getv()+" ";
			    }
				else ch+="O ";
			}
			
			ch+="\n";
		}
		System.out.println(ch);
	}*/
	
	public int checkgameover() {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				//System.out.println("["+m[i][j].getv()+"/"+m[i][j].getc()+"]");
				if (m[i][j].getv()<0 && m[i][j].getc()==0) return -1;
			}
		}
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if (m[i][j].getv()>=0 && m[i][j].getc()==1) return 0;
			}
		}
		return 1;
	}
	/*public void play() {
		int i;
		int j;
		do {
			System.out.println("Saisir Les Coord");
			i=sc.nextInt();
			j=sc.nextInt();
		}while(m[i][j].getc()==0);
		affnei(i,j,0);
		//testwin();
		afficher();
	}
	public void playy(int i,int j) {
		affnei(i,j,0);
		//testwin();
		afficher();
	}
	public void testwin() {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(m[i][j].getv()>=0) m[i][j].setc(0);
			}
		}
	}*/
	public void affnei(int i,int j,int a) {
		if (m[i][j].getv()<0 ) {
			m[i][j].setc(0);
			return;
		}
		if(m[i][j].getv()>=0 & m[i][j].getc()==1) {
			m[i][j].setc(0);
			nbrcasvalres();
			if(i!=0 && m[i-1][j].getc()==1 && m[i-1][j].getv()>=0 ) {
				if(a<2 && NbrCres>20) affnei(i-1,j,numminapr(i-1,j));
			}
			if(i!=9 && m[i+1][j].getc()==1 && m[i+1][j].getv()>=0){
				if(a<2 && NbrCres>20) affnei(i+1,j,numminapr(i+1,j));
			}
			if(j!=0 && m[i][j-1].getc()==1 && m[i][j-1].getv()>=0) {
				if(a<2 && NbrCres>20) affnei(i,j-1,numminapr(i,j-1));
			}
			if(j!=9 && m[i][j+1].getc()==1 && m[i][j+1].getv()>=0) {
				if(a<2 && NbrCres>20) affnei(i,j+1,numminapr(i,j+1));
			}
		}
	}
	private int numminapr(int i,int j) {
		int a=0,b=0,c=0,d=0;
		if(i!=0 && m[i-1][j].getv()!=0) {
			a++;
			b++;
			c++;
			d++;
		}
		if(i!=9 && m[i+1][j].getv()!=0) {
			a++;
			b++;
			c++;
			d++;
		}
		if(j!=0 && m[i][j-1].getv()!=0) {
			a++;
			b++;
			c++;
			d++;
		}
		if(j!=9 && m[i][j+1].getv()!=0) {
			a++;
			b++;
			c++;
			d++;
		}
		return Math.max(Math.max(a, b), Math.max(c, d));
	}
	void nbrcasvalres() {
		NbrCres=0;
			for(int i=0;i<10;i++) {
				for(int j=0;j<10;j++) {
					if(m[i][j].getc()==1) NbrCres++;
				}
			}
	}
}
