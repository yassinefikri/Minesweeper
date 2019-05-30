
public class Case {
	private int v;
	private int c;
	public Case() {
		v=0;
		c=1;
	}
	public int getv() {return v;}
	public int getc() {return c;}
	public void setc(int c) {this.c=c;}
	public void setv(int v) {this.v=v;}
	public String toString() {
		return "["+v+"] ";
	}
}
