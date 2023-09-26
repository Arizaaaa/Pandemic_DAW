import java.awt.Color;
import java.util.ArrayList;

public class HiloPrincipal extends Thread{

	public void run() {

		do {
			synchronized (PanelJuego.objeto) {
				
				//Carga de energía
				if (PanelJuego.cura && PanelJuego.barra.getValue() >=250 && PanelJuego.ciudadesLista.get(PanelJuego.paisSeleccionado).getCiudadMuerta() == 0) {PanelJuego.barra.setValue(PanelJuego.barra.getValue()-250); PanelJuego.cura = false; PanelJuego.ciudadesLista.get(PanelJuego.paisSeleccionado).curar(PanelJuego.investigadoAm, PanelJuego.investigadoAz, PanelJuego.investigadoR, PanelJuego.investigadoV); PanelJuego.nivel(PanelJuego.paisSeleccionado);}
				
				if (PanelJuego.investigaAm) {PanelJuego.barra.setValue(0); PanelJuego.investigarAm.setVisible(false); PanelJuego.investigarAm.setEnabled(false); 
					if(!PanelJuego.investigadoAz) {PanelJuego.investigarAz.setVisible(false); PanelJuego.investigarAz.setEnabled(false);}
					if(!PanelJuego.investigadoR) {PanelJuego.investigarR.setVisible(false); PanelJuego.investigarR.setEnabled(false);}
					if(!PanelJuego.investigadoV) {PanelJuego.investigarV.setVisible(false); PanelJuego.investigarV.setEnabled(false);}}
				
				if (PanelJuego.investigaAz) {PanelJuego.barra.setValue(0); PanelJuego.investigarAz.setVisible(false); PanelJuego.investigarAz.setEnabled(false);
					if(!PanelJuego.investigadoAm) {PanelJuego.investigarAm.setVisible(false); PanelJuego.investigarAm.setEnabled(false);}
					if(!PanelJuego.investigadoR) {PanelJuego.investigarR.setVisible(false); PanelJuego.investigarR.setEnabled(false);}
					if(!PanelJuego.investigadoV) {PanelJuego.investigarV.setVisible(false); PanelJuego.investigarV.setEnabled(false);}}
				
				if (PanelJuego.investigaR) {PanelJuego.barra.setValue(0); PanelJuego.investigarR.setVisible(false); PanelJuego.investigarR.setEnabled(false);
					if(!PanelJuego.investigadoAz) {PanelJuego.investigarAz.setVisible(false); PanelJuego.investigarAz.setEnabled(false);}
					if(!PanelJuego.investigadoAm) {PanelJuego.investigarAm.setVisible(false); PanelJuego.investigarAm.setEnabled(false);}
					if(!PanelJuego.investigadoV) {PanelJuego.investigarV.setVisible(false); PanelJuego.investigarV.setEnabled(false);}}
				
				if (PanelJuego.investigaV) {PanelJuego.barra.setValue(0); PanelJuego.investigarV.setVisible(false); PanelJuego.investigarV.setEnabled(false);
					if(!PanelJuego.investigadoAz) {PanelJuego.investigarAz.setVisible(false); PanelJuego.investigarAz.setEnabled(false);}
					if(!PanelJuego.investigadoR) {PanelJuego.investigarR.setVisible(false); PanelJuego.investigarR.setEnabled(false);}
					if(!PanelJuego.investigadoAm) {PanelJuego.investigarAm.setVisible(false); PanelJuego.investigarAm.setEnabled(false);}}
				
					PanelJuego.barra.setForeground(new Color(255, 255-(PanelJuego.barra.getValue()/10), 00));
			}
			PanelJuego.barra.setValue(PanelJuego.barra.getValue()+50);
			
			//Actualización de datos
			PanelJuego.poblacion.setText(PanelJuego.ciudadesLista.get(PanelJuego.paisSeleccionado).getPoblacionMuerta() + " / " + PanelJuego.ciudadesLista.get(PanelJuego.paisSeleccionado).getPoblacionTotal());
			PanelJuego.nivelRojo.setText("Nivel Rojo: " + PanelJuego.ciudadesLista.get(PanelJuego.paisSeleccionado).getRojo());
			PanelJuego.nivelAzul.setText("Nivel Azul: " + PanelJuego.ciudadesLista.get(PanelJuego.paisSeleccionado).getAzul());
			PanelJuego.nivelVerde.setText("Nivel Verde: " + PanelJuego.ciudadesLista.get(PanelJuego.paisSeleccionado).getVerde());
			PanelJuego.nivelAmarillo.setText("Nivel Amarillo: " + PanelJuego.ciudadesLista.get(PanelJuego.paisSeleccionado).getAmarillo());
			PanelJuego.rojo.setText(PanelJuego.totalRojo + " / " + PanelJuego.limiteEnfermedadRoja);
			PanelJuego.azul.setText(PanelJuego.totalAzul + " / " + PanelJuego.limiteEnfermedadAzul);
			PanelJuego.verde.setText(PanelJuego.totalVerde + " / " + PanelJuego.limiteEnfermedadVerde);
			PanelJuego.amarillo.setText(PanelJuego.totalAmarillo + " / " + PanelJuego.limiteEnfermedadAmarilla);
			PanelJuego.totales.setText(PanelJuego.totalEnfermedades +" / "+ PanelJuego.limiteEnfermedad);
			PanelJuego.brotes.setText(PanelJuego.contadorBrotes+" / "+ PanelJuego.limiteBrotes);
			
			//Comprobación de derrota
			PanelJuego.limiteContagios();
//			if(PanelJuego.muertosTotales >=  PanelJuego.limiteMuertos || PanelJuego.totalAmarillo == PanelJuego.limiteEnfermedadAmarilla || PanelJuego.totalAzul == PanelJuego.limiteEnfermedadAzul || PanelJuego.totalRojo == PanelJuego.limiteEnfermedadRoja || PanelJuego.totalVerde == PanelJuego.limiteEnfermedadVerde || PanelJuego.totalEnfermedades == PanelJuego.limiteEnfermedad || PanelJuego.limiteBrotes == PanelJuego.contadorBrotes) {
//				
//				PanelJuego.continuar.setVisible(true);
//				PanelJuego.derrota.setVisible(true);
//				PanelJuego.parar = true;
//			} else
//				if (PanelJuego.investigadoAm && PanelJuego.investigadoAz && PanelJuego.investigadoR && PanelJuego.investigadoV) {
//				
//				PanelJuego.continuar.setVisible(true);
//				PanelJuego.victoria.setVisible(true);
//				PanelJuego.parar = true;
//			}
			
			//Comprobación de contagio
			PanelJuego.contadorBrotes=0;
			
			int ran = PanelJuego.rd.nextInt(4);
			int rn = PanelJuego.rd.nextInt(59);
			 
			if (ran == 0) {
				if (PanelJuego.ciudadesLista.get(rn).getRojo() < 3) {PanelJuego.ciudadesLista.get(rn).setRojo(PanelJuego.ciudadesLista.get(rn).getRojo() + 1); PanelJuego.nivel(rn);
				}else {brote(rn,1); PanelJuego.contadorBrotes += 1;}
			} else if (ran == 1) {
				if (PanelJuego.ciudadesLista.get(rn).getVerde() < 3) { PanelJuego.ciudadesLista.get(rn).setVerde(PanelJuego.ciudadesLista.get(rn).getVerde() + PanelJuego.habilidad.getContagio()); PanelJuego.nivel(rn);
				}else {brote(rn,2); PanelJuego.contadorBrotes += 1;}
			} else if (ran == 2) {
				if (PanelJuego.ciudadesLista.get(rn).getAmarillo() < 3) { PanelJuego.ciudadesLista.get(rn).setAmarillo(PanelJuego.ciudadesLista.get(rn).getAmarillo() + 1); PanelJuego.nivel(rn);
				}else {brote(rn,3); PanelJuego.contadorBrotes += 1;}
			} else if (ran == 3) {
				if (!PanelJuego.evolucionV) {
					if (PanelJuego.ciudadesLista.get(rn).getAzul() < 3) { PanelJuego.ciudadesLista.get(rn).setAzul(PanelJuego.ciudadesLista.get(rn).getAzul() + 1); PanelJuego.nivel(rn);
					}else {brote(rn,4); PanelJuego.contadorBrotes += 1;}
				}else {
					if (PanelJuego.ciudadesLista.get(rn).getAzul() < 3) { PanelJuego.ciudadesLista.get(rn).setAzul(PanelJuego.ciudadesLista.get(rn).getAzul() + 1); PanelJuego.nivel(rn);
					}else {brote(rn,4); PanelJuego.contadorBrotes += PanelJuego.habilidad.getContagio();}
				}
			}
			
			try {Thread.sleep(500);} catch (InterruptedException e) {}
		} while(!PanelJuego.parar);
	}
	
	//Calcula los brotes totales
	public static void brote(int rn, int id) {
		
		ArrayList<String> colindantes = new ArrayList<>();

		colindantes = PanelJuego.ciudadesLista.get(rn).getColindantes();
		
		for (int i = 0; i < colindantes.size(); i++) {
			
			for (int j = 0; j < colindantes.size(); j++) {
				
				if (colindantes.get(i).equals(PanelJuego.ciudadesLista.get(j).getNombre())) {

					if (id == 1  && PanelJuego.ciudadesLista.get(j).getRojo() < 3) { PanelJuego.ciudadesLista.get(j).setRojo(PanelJuego.ciudadesLista.get(j).getRojo() + 1); PanelJuego.nivel(j);}
					else if (id == 2 && PanelJuego.ciudadesLista.get(j).getAmarillo() < 3) { PanelJuego.ciudadesLista.get(j).setAmarillo(PanelJuego.ciudadesLista.get(j).getAmarillo() + 1); PanelJuego.nivel(j);}
					else if (id == 3 && PanelJuego.ciudadesLista.get(j).getRojo() < 3) { PanelJuego.ciudadesLista.get(j).setAzul(PanelJuego.ciudadesLista.get(j).getAzul() + 1); PanelJuego.nivel(j);}
					else if (id == 4 && PanelJuego.ciudadesLista.get(j).getVerde() < 3) { PanelJuego.ciudadesLista.get(j).setVerde(PanelJuego.ciudadesLista.get(j).getVerde() +PanelJuego.habilidad.getContagio()); PanelJuego.nivel(j);}
					
				}
			}			
		}
		// 1 rojo // 2 verde // 3 amarillo // 4 azul
	}
}