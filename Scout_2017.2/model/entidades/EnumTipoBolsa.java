package model.entidades;

public class EnumTipoBolsa {
	public static enum tipoBolsa {

        permAcademica ("Permanência Acadêmica", 1),
        apoioEsporte ("Apoio ao Esporte", 2),
        auxPortNecEsp("Aux. ao Portador de Necessidades Especiais", 3),
        auxAlimentacao ("Aux. Alimentação", 4),
        auxDidPed ("Aux. Didático-Pedagógico", 5),
        auxTranporte ("Aux. Transporte", 6),
        auxCreche ("Aux. Creche", 7),
        auxMoradia ("Aux. Moradia", 8),
        moradiaEstudantil ("Moradia Estudantil", 9);

    	private int _id;
    	private String label;
    	
        tipoBolsa (String label, int id)
		{
            this.label = label;
            this._id = id;
        }

		public String getLabelOferta(){
			return this.label;
		}

        public static tipoBolsa permissiveValueOf_int(int id)
		{
            for (tipoBolsa e : values())
                if (e.ordinal() == (id-1))
                    return e;
            return null;
        }
        
        public static String permissiveValueOf_byte(byte tipoOferta)
		{
            for (tipoBolsa e : values())
                if (e.ordinal() == (tipoOferta-1))
                    return e.getLabelOferta();
            return null;
        }
        
        public static tipoBolsa permissiveValueOf_bolsa(tipoBolsa bolsa)
		{
            for (tipoBolsa e : values())
                if (e.ordinal() == (bolsa._id-1))
                    return e;
            return null;
        }
        
		public String toString() {
            return _id + ". " + label;
        }
    }
	//lalala
}
