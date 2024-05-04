package PoslovanjeBanaka;

public interface RadSaTransakcijama{
	boolean izvrsiInternuTransakciju(Klijent posiljalac, Klijent primalac, float iznos);
}
