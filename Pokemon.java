import java.util.*;

public class Pokemon implements Normal, Fire, Fighting, Water, Flying, Grass, Poison, Electric,
        Ground, Psychic, Rock, Ice, Bug, Dragon, Ghost, Dark, Steel, Fairy{
    public String name;
    public int hp;
    public int attack;
    public int defense;
    public int speed;
    public int type1;
    public int type2=18;
    public double[] weaknesses;
    public String picturePath;

    static public ArrayList<Pokemon> pokedex=new ArrayList();

    static Integer getIndex(String name){
            for(int i=0;i< pokedex.size();i++) {
                if (name == pokedex.get(i).name) {
                    return i;
                }
            }
        return null;
    }

    @Override
    public String toString(){
        String to_return = "Name: "+ name+"\nHP: "+ hp+"\nAttack: "+ attack+"\nDefense: "+ defense+"\nSpeed: "+ speed+"\nType/s: ";
        if(type2==18) to_return=to_return.concat(types.get(type1));
        else to_return=to_return.concat(types.get(type1)+"/"+types.get(type2));
        return to_return;
    }

    static ArrayList<double[]> types_weaknesses=new ArrayList<>();
    static ArrayList<String> types = new ArrayList<>();

    static void add_types_weaknesses(){
        types_weaknesses.add(Normal.weakness());
        types_weaknesses.add(Fire.weakness());
        types_weaknesses.add(Fighting.weakness());
        types_weaknesses.add(Water.weakness());
        types_weaknesses.add(Flying.weakness());
        types_weaknesses.add(Grass.weakness());
        types_weaknesses.add(Poison.weakness());
        types_weaknesses.add(Electric.weakness());
        types_weaknesses.add(Ground.weakness());
        types_weaknesses.add(Psychic.weakness());
        types_weaknesses.add(Rock.weakness());
        types_weaknesses.add(Ice.weakness());
        types_weaknesses.add(Bug.weakness());
        types_weaknesses.add(Dragon.weakness());
        types_weaknesses.add(Ghost.weakness());
        types_weaknesses.add(Dark.weakness());
        types_weaknesses.add(Steel.weakness());
        types_weaknesses.add(Fairy.weakness());
    }

    static void add_types(){
        types.add("Normal"); //0
        types.add("Fire"); //1
        types.add("Fighting"); //2
        types.add("Water"); //3
        types.add("Flying"); //4
        types.add("Grass"); //5
        types.add("Poison"); //6
        types.add("Electric"); //7
        types.add("Ground"); //8
        types.add("Psychic"); //9
        types.add("Rock"); //10
        types.add("Ice"); //11
        types.add("Bug"); //12
        types.add("Dragon"); //13
        types.add("Ghost"); //14
        types.add("Dark"); //15
        types.add("Steel"); //16
        types.add("Fairy"); //17
    }

    public Pokemon(){}

    public Pokemon(String name, int hp, int attack, int defense, int speed, int type1, String picturePath){
        Pokemon pokemon = new Pokemon();
        pokemon.name =name;
        pokemon.hp =hp;
        pokemon.attack =attack;
        pokemon.defense =defense;
        pokemon.speed =speed;
        pokemon.type1 =type1;
        pokemon.weaknesses=weakness(type1);
        pokemon.picturePath=picturePath;
        pokedex.add(pokemon);
    }

    public Pokemon(String name, int hp, int attack, int defense, int speed, int type1, int type2, String picturePath){
        Pokemon pokemon = new Pokemon();
        pokemon.name =name;
        pokemon.hp =hp;
        pokemon.attack =attack;
        pokemon.defense =defense;
        pokemon.speed =speed;
        pokemon.type1 =type1;
        pokemon.type2 =type2;
        pokemon.weaknesses=weakness(type1,type2);
        pokemon.picturePath=picturePath;
        pokedex.add(pokemon);
    }

    double[] weakness(int type1) {
        return types_weaknesses.get(type1);
    }

    double[] weakness(int type1, int type2){
        add_types_weaknesses();
        double[] weaknesses=new double[18];
        double[] weak1=types_weaknesses.get(type1);
        double[] weak2=types_weaknesses.get(type2);
        for(int i =0;i<18;i++){
            weaknesses[i]=weak1[i]*weak2[i];
        }
        return  weaknesses;
    }
}

