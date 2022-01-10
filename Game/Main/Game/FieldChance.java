public class FieldChance extends Field{
    public FieldChance(String name, String FieldType){
        super(name,FieldType);


    }
    @Override
    public String toString(){
        return "You landed on field"+this.name;
    }
}
