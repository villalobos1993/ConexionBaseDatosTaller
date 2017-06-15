package Models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Vistas.CrearVehiculo;

public class Validaciones {

	/**
	 * 
	 * @param nombre
	 * @return
	 */
	static public String validarNombre(String nombre) {

		char[] c = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		if (nombre.isEmpty()) {

			JOptionPane.showMessageDialog(null, "Debes escribir un nombre");
			return "0";
		}
		for (int i = 0; i < nombre.length() - 1; i++) {
			for (int j = 0; j < nombre.length(); j++) {
				if (nombre.charAt(i) == c[j]) {

					JOptionPane.showMessageDialog(null, "Debes escribir un nombre");
					return "0";

				}

			}

		}

		return nombre;
	}

	/**
	 * 
	 * @param apellido
	 * @return
	 */
	static public String apellido1(String apellido) {
		char[] c = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		if (apellido.isEmpty()) {

			JOptionPane.showMessageDialog(null, "Debes escribir un primer Apellido");
			return "0";
		}
		for (int i = 0; i < apellido.length() - 1; i++) {
			for (int j = 0; j < apellido.length(); j++) {
				if (apellido.charAt(i) == c[j]) {

					JOptionPane.showMessageDialog(null, "Debes escribir un primer Apellido que no contenga numeros");
					return "0";

				}

			}
		}

		return apellido;

	}

	/**
	 * 
	 * @param apellido
	 * @return
	 */
	static public String apellido2(String apellido) {
		char[] c = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		if (apellido.isEmpty()) {

			JOptionPane.showMessageDialog(null, "Debes escribir un segundo Apellido");
			return "0";
		}
		for (int i = 0; i < apellido.length() - 1; i++) {
			for (int j = 0; j < apellido.length(); j++) {
				if (apellido.charAt(i) == c[j]) {

					JOptionPane.showMessageDialog(null, "Debes escribir el segundo Apellido que no contenga numeros");
					return "0";

				}

			}
		}

		return apellido;

	}

	/**
	 * Validacion dni
	 * 
	 * @param nDni
	 *            numero dni
	 * @param letra
	 *            es la letra del dni
	 * @return el String dni si es correcto;
	 */
	static public String validarDni(String nDni, String letra) {
		int dni = 0;
		String dni1;
		String letrasdni = "TRWAGMYFPDXBNJZSQVHLCKE";

		if (nDni.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes introducir un dni");
			return "0";
		}
		if (nDni.length() != 8) {
			JOptionPane.showMessageDialog(null, "El dni debe contener 8 digitos");
			return "0";
		}
		if (letra.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El dni debe contener 9 digitos");
			return "0";
		}
		if (letra.length() != 1) {
			JOptionPane.showMessageDialog(null, "La letra debe ser 1 sola");
			return "0";
		}

		try {
			dni = Integer.parseInt(nDni);

		} catch (Exception ee) {

			JOptionPane.showMessageDialog(null, "El numero de dni debe ser numerico");
			return "0";
		}

		for (int i = 0; i < letrasdni.length(); i++) {

			if (letra.toUpperCase().charAt(0) == (letrasdni.charAt(i))) {
				dni1 = dni + letra;
				return dni1;
			}
		}

		return "0";

	}

	/**
	 * Verificar Direccion
	 * 
	 * @param direccion
	 * @return
	 */
	static public String validarDireccion(String direccion) {

		if (direccion.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes introducir un Email");
			return direccion = "0";
		}
		return direccion;
	}

	static public String validarEmail(String email) {

		if (email.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes introducir un Email");
			return email = "0";
		}

		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher mather = pattern.matcher(email);

		if (mather.find() == false) {
			JOptionPane.showMessageDialog(null, "El email ingresado es válido.");
			return email = "0";
		}

		return email;
	}

	/**
	 * Verificar telefono
	 * 
	 * @param telefono
	 * @return
	 */
	static public String validarTelefono(String telefono) {
		int telefone;
		if (telefono.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes introducir un Telefono");
			return telefono = "0";
		}
		if (telefono.length() != 9) {
			JOptionPane.showMessageDialog(null, "El Telefono debe disponer de 9 digitos");
			return telefono = "0";
		}
		try {
			telefone = Integer.parseInt(telefono);

		} catch (Exception ee) {

			JOptionPane.showMessageDialog(null, "El numero de telefono debe ser numerico");
			return telefono = "0";
		}

		return telefono;
	}

	static public String validarmatricula(String matricula) {

		Pattern pat = Pattern.compile("^[0-9]{4}[a-zA-Z]{3}$");
		Matcher mat = pat.matcher(matricula);

		if (matricula.isEmpty()) {

			JOptionPane.showMessageDialog(null, "ERROR: Inserte una matricula correcta");
			return "0";
		}
		if (!mat.matches()) {
			JOptionPane.showMessageDialog(null, "ERROR: Inserte una matricula correcta");
			return "0";
		} else {

			return matricula;
		}

	}

	static public String validarmarca(String marca) {

		if (marca == null) {
			JOptionPane.showMessageDialog(null, "ERROR: Seleccione una marca ");
			return "0";

		} else {
			return marca;

		}

	}

	static public String validarmodelo(String modelo) {

		if (modelo.isEmpty()) {

			JOptionPane.showMessageDialog(null, "ERROR: Inserte un modelo correcto");
			return "0";
		} else {

			return modelo;
		}

	}

	static public String validarcombustible(String tipo) {

		if (tipo == null) {

			JOptionPane.showMessageDialog(null, "ERROR: Seleccione tipo de combustible");
			return "0";
		} else {

			return tipo;
		}

	}

	static public int validarcv(String numero) {
		int cv;
		boolean escorrecto = true;

		try {
			cv = Integer.parseInt(numero);

		} catch (Exception e2) {

			JOptionPane.showMessageDialog(null, "ERROR: Los CV deben ser numericas");
			escorrecto = false;
			return 0;

		}

		if (escorrecto && cv > 0) {

			return cv;
		} else {
			JOptionPane.showMessageDialog(null, "ERROR: Los CV deben ser >0");
			return 0;
		}

	}
	
	static public String validarcolor(String color)
	{
		
		if (color == null) {

			JOptionPane.showMessageDialog(null, "ERROR: Seleccione un color ");
			return "0";
		} else {

			return color;
		}

	}

}
