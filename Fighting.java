public interface Fighting {
    static double[] weakness() {
        double[] weaknesses = new double[18];
        weaknesses[0] = 1; //normal
        weaknesses[1] = 1; //fire
        weaknesses[2] = 1; //fighting
        weaknesses[3] = 1; //water
        weaknesses[4] = 2; //flying
        weaknesses[5] = 1; //grass
        weaknesses[6] = 1; //poison
        weaknesses[7] = 1; //electric
        weaknesses[8] = 1; //ground
        weaknesses[9] = 2; //psychic
        weaknesses[10] = 0.5; //rock
        weaknesses[11] = 1; //ice
        weaknesses[12] = 0.5; //bug
        weaknesses[13] = 1; //dragon
        weaknesses[14] = 1; //ghost
        weaknesses[15] = 0.5; //dark
        weaknesses[16] = 1; //steel
        weaknesses[17] = 1; //fairy
        return weaknesses;
    }
}

