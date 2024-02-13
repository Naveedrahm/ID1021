public class item {
        private ItemType type;
        private int value = 0;

        public item(ItemType type, int value){
            this.type = type;
            this.value = value;
        }
        public enum ItemType {
            ADD,
            SUB,
            MUL,
            DIV,
            VALUE
        } 

        public static item Add(){
            return new item(ItemType.ADD, 0);
        }
        
        public static item Sub(){
            return new item(ItemType.SUB, 0);
        }
        
        public static item Div(){
            return new item(ItemType.DIV, 0);
        }
        
        public static item Mul(){
            return new item(ItemType.MUL, 0);
        }
        
        public static item Value(int value){
            return new item(ItemType.VALUE, value);
        }

    public ItemType type(){
        return this.type;
    }
    public int value(){
        return this.value;
    }
    
}


