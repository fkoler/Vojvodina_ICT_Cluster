package KolekcijaOsoba;

import java.util.*;

class MojKomparator implements Comparator<Osoba> {

	@Override
	public int compare(Osoba o1, Osoba o2) {
		int i = o1.pribaviJMBG().compareTo(o2.pribaviJMBG());
		if (i > 0) {
			return -1;
		} else if (i < 0) {
			return 1;
		}
		return 0;
	}
}
