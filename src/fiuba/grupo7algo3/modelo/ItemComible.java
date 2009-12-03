
abstract class ItemComible {
        
        private int     puntajePredeterminado;
        private boolean esPowa;
        
        public ItemComible (int nuevoPuntaje, boolean esPowa){

                this.puntajePredeterminado=nuevoPuntaje;
                this.esPowa=esPowa;
                                
        }
        
        public int getPuntaje(){
                return this.puntajePredeterminado;
        }
        
        
        protected boolean esDePoder(){
                return esPowa;
        }
}
 
	
		
	
