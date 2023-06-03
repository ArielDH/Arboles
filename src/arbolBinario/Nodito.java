package arbolBinario;

public class Nodito<T> {
		 T info;
		 Nodito izq;
		 Nodito der;

		public Nodito(T dato) {
			this.info=dato;
			this.izq=null;
			this.der=null;
		}

		public T getInfo() {
			return info;
		}

		public void setInfo(T info) {
			this.info = info;
		}

		public Nodito getIzq() {
			return izq;
		}

		public void setIzq(Nodito izq) {
			this.izq = izq;
		}

		public Nodito getDer() {
			return der;
		}

		public void setDer(Nodito der) {
			this.der = der;
		}
}
