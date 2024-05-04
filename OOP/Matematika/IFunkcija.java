package Matematika;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public interface IFunkcija {

	public void ucitajParametre(BufferedReader parametar) throws IOException;

	public double vrednostTacke(double x);

	public Boolean imaNulu();

	public double nadjiNulu();

	public void stampajPodatke(BufferedWriter podatak);
}
