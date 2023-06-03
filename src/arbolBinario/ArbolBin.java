package arbolBinario;

import javax.swing.JOptionPane;

import ToolsPanel.Tools;

public class ArbolBin<T> {
	private Nodito raiz;
	public ArbolBin() {
		raiz=null;
	}
	public Nodito getRaiz() {
		return raiz;
	}
	public void setRaiz(Nodito raiz) {
		this.raiz = raiz;
	}
	public boolean arbolVacio() {
		return raiz==null;
	}
	public void VaciarArbol() {
		raiz=null;
	}
	public void InsertarArbol(T info) {
		Nodito p= new Nodito(info);//construye el nodo y almacena lo que tiene info
		if(arbolVacio()) {
			raiz=p; 
		}else {
			Nodito padre=buscarPadre(raiz ,p);
			if(p.hashCode()>=padre.hashCode())
				padre.der=p;
			else 
				padre.izq=p;
		}
	}
	public Nodito buscarPadre(Nodito actual,Nodito p) {
		Nodito padre=null;
		while(actual!=null) {
			padre=actual;
			if((int )p.info>=(int)padre.info)
				actual=padre.der;
			else 
				actual=padre.izq;
		}
		return padre;
	}
	public String preorden(Nodito r) {// re es la raiz
		if(r!=null) {
			return r.info+".."+preorden(r.izq)+".."+preorden(r.der);
		}
		else return"";
	}
	public String  inorden(Nodito r) {
		if(r!=null) {
			return inorden(r.izq)+".."+r.info+".."+inorden(r.der);
			
		}
		else return "";
	}
	public String posorden(Nodito r) {
		if(r!=null) {
			return posorden(r.izq)+".."+posorden(r.der)+".."+r.info;
		}
		else return "";
	}
	public String inordenII(Nodito r) {
		if(r!=null) {
			return inorden(r.der)+".."+r.info+".."+inorden(r.izq);
			
		}
		else return "";
	}
	public Nodito Buscar(Nodito r, int dato) {
		while (r != null) {
			if (r.getInfo().equals(dato)) {
				return r;
			} else {
				int y = (int) r.info;

				if (dato > y) {
					r = r.getIzq();
				} else {
					r = r.getDer();
				}
			}
		}
		return r;
	}
	
	public String imprimirhojas(Nodito r) {
		String cad = "";
		if (r != null) {
			if (r.izq == null && r.der == null) {
				cad = r.info + "...";
			}
			return cad + imprimirhojas(r.izq) + imprimirhojas(r.der);
		} else {
			return "";
		}
	}

	public String interiores(Nodito n) {
		String cad = "";
		if (n != null) {
			
			if (n.izq != null || n.der != null) {
				if(n.info!=raiz.info)
				cad = n.info + "...";
			}
			return cad +interiores(n.izq) + interiores(n.der);
		} else {
			return "";
		}
	}
	
	public int Altura(Nodito n) {
		return (n != null) ? Math.max(Altura(n.izq), Altura(n.der)) + 1
				: 0;
	}
	public static void mostrar(Nodito n, int l) {
		if (n == null) return;
	
		mostrar(n.der, l + 1);
		
		if (l != 0) {
				for (int i = 0; i < l - 1; i++) {
						System.out.print("|\t");
				}
				System.out.println("|-----" + n.info);
		} else {
				System.out.println(n.info);
		}
		mostrar(n .izq, l + 1);
}
	public void imprimirArbol(Nodito nd, String p, boolean ultimo) {
		if (nd == null) {
			return;
		}
		imprimirArbol(nd.der, p + (ultimo ? "    " : "|   "), false);
		System.out.print(p);
		System.out.print(ultimo ? "|--" : "|--");
		System.out.println(nd.info);

		imprimirArbol(nd.izq, p + (ultimo ? "|   " : "    "), true);
	}

}
