public interface Water {
    static double[] weakness() {
        double[] weaknesses = new double[18];
        weaknesses[0] = 1; //normal
        weaknesses[1] = 0.5; //fire
        weaknesses[2] = 1; //fighting
        weaknesses[3] = 0.5; //water
        weaknesses[4] = 1; //flying
        weaknesses[5] = 2; //grass
        weaknesses[6] = 1; //poison
        weaknesses[7] = 2; //electric
        weaknesses[8] = 1; //ground
        weaknesses[9] = 1; //psychic
        weaknesses[10] = 1; //rock
        weaknesses[11] = 0.5; //ice
        weaknesses[12] = 1; //bug
        weaknesses[13] = 1; //dragon
        weaknesses[14] = 1; //ghost
        weaknesses[15] = 1; //dark
        weaknesses[16] = 0.5; //steel
        weaknesses[17] = 1; //fairy
        return weaknesses;
    }
}

