package mz.com.vm.http;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PseudoRN {

	private int codigo;
	private long pnR;
	private long time;
	
	public PseudoRN(){
		
	}
	
	public PseudoRN(int codigo, long pnR, long time) {
		super();
		this.codigo = codigo;
		this.pnR = pnR;
		this.time =time;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public long getPnR() {
		return pnR;
	}

	public void setPnR(long pnR) {
		this.pnR = pnR;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

		

}
