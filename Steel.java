public interface Steel {
    static double[] weakness() {
        double[] weaknesses = new double[18];
        weaknesses[0] = 0.5; //normal
        weaknesses[1] = 2; //fire
        weaknesses[2] = 2; //fighting
        weaknesses[3] = 1; //water
        weaknesses[4] = 0.5; //flying
        weaknesses[5] = 0.5; //grass
        weaknesses[6] = 0; //poison
        weaknesses[7] = 1; //electric
        weaknesses[8] = 2; //ground
        weaknesses[9] = 0.5; //psychic
        weaknesses[10] = 0.5; //rock
        weaknesses[11] = 0.5; //ice
        weaknesses[12] = 0.5; //bug
        weaknesses[13] = 0.5; //dragon
        weaknesses[14] = 0.5; //ghost
        weaknesses[15] = 0.5; //dark
        weaknesses[16] = 0.5; //steel
        weaknesses[17] = 1; //fairy
        return weaknesses;
    }
}

