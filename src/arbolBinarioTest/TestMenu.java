package arbolBinarioTest;



import javax.swing.JOptionPane;

import ToolsPanel.Tools;
import arbolBinario.ArbolBin;
import arbolBinario.Nodito;

public class TestMenu {
	public static void menu3(String menu)
    {
ArbolBin <Integer>  arbol = new ArbolBin();
        String sel="";
 
        do {
            sel=boton(menu);
            switch(sel){
                case "Insertar":
                   arbol.InsertarArbol(Tools.leerInt("Dato"));
                    break;
                case "Recorridos":
	                   Tools.imprime( "\nPreorden"+arbol.preorden( arbol.getRaiz())+"\nInorden"+arbol.inorden(arbol.getRaiz())+"\nPosorden"+arbol.posorden(arbol.getRaiz())+"\nInordenII"+arbol.inordenII(arbol.getRaiz()));
                    break;
                case "Buscar":
                	if (arbol.arbolVacio()) {
						Tools.imprimeErrorMsje("Arbol vacio ");
					} else {
						int datoBuscar = Tools.leerInt("Ingresa valor a buscar");
						Nodito resultado = arbol.Buscar(arbol.getRaiz(), datoBuscar);

						if (resultado != null) {
							Tools.imprime("El dato " + datoBuscar + " se encuentra en el arbol");
						} else {
							Tools.imprime("El dato " + datoBuscar + " no se encuentra en el  rbol");
						}
					}
					break;
                case "Hojas":
                	if (arbol.arbolVacio()) {
                		Tools.imprimeErrorMsje("Arbol vacio");
					} else {				
						Tools.imprime("Las hojas del arbol son: \n" + arbol.imprimirhojas(arbol.getRaiz()));
						Tools.imprime("Los interiores del arbol son: \n" + arbol.interiores(arbol.getRaiz()));
						
					}
                	break;
                case "Altura":
                	if (arbol.arbolVacio()) {
                		Tools.imprimeErrorMsje("Arbol vacio");
					} else {
						Tools.imprime("altura : \n" + arbol.Altura(arbol.getRaiz()));
					}
                	break;
                case "Ver":
                	if (arbol.arbolVacio()) {
                		Tools.imprimeErrorMsje("arbol vacio");
					} else {
						System.out.println("El arbol binario es : \n");
						arbol.mostrar(arbol.getRaiz(), 0);
					}
                	break;
                case "Salir": 
                	Tools.imprime("Fin del programa");  
                break;
            }
        }while(!sel.equalsIgnoreCase("Salir"));
    }
    public static void main(String[] args) {
        String menu = "Insertar,Recorridos,Buscar,Hojas,Altura,Ver,Salir";
        menu3(menu);
    }
    public static String boton(String menu) {
        String valores[]=menu.split(",");
        int n;
        n = JOptionPane.showOptionDialog(null," SELECCIONA DANDO CLICK ", " M E N U",
                JOptionPane.NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,
                valores,valores[0]);
        return ( valores[n]);
    }
}
