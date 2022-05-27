public class Property {
    // member variables
    public String name;
    public int cost;
    public int houses;
    public int mortgage;
    public int houseCost;
    public int ownerIndex;
    public boolean owned;
    public boolean isChance;
    public boolean isCommunityChest;
    public boolean isUtility;
    public boolean isRailroad;
    public boolean isProperty; 
    public int[] rents = new int[6];
    public int[] railroadRent = new int[4];
    

    

    //constructor
    public Property(String propertyName, int propertyCost, int propertyMortgage, int propertyHouseCost, int[] propertyRents, boolean isChanceProperty, boolean isCommunityChestProperty, boolean isRailroadProperty, boolean isUtilityProperty, boolean isAProperty){
        name = propertyName;
        cost = propertyCost;
        houses = 0;
        mortgage = propertyMortgage;
        houseCost = propertyHouseCost;
        ownerIndex = -1;
        owned = false;
        isChance = isChanceProperty;
        isCommunityChest = isCommunityChestProperty;
        rents = propertyRents.clone();

    }
    //free parking and other spaces like that
    public Property(String propertyName, boolean isChanceProperty, boolean isCommunityChestProperty, boolean isRailroadProperty, boolean isUtilityProperty, boolean isAProperty){
        name = propertyName;
        isChance = isChanceProperty;
        isCommunityChest = isCommunityChestProperty;
    }
    //railroads
    public Property(String propertyName, int propertyCost, int railroadMortgage, int[] railroadRents, boolean isChanceProperty, boolean isCommunityChestProperty, boolean isRailroadProperty, boolean isUtilityProperty, boolean isAProperty){
        name = propertyName;
        cost = propertyCost;
        isChance = isChanceProperty;
        isCommunityChest = isCommunityChestProperty;
        mortgage = railroadMortgage;
        railroadRent = railroadRents.clone();
    }
    //utilities
    public Property(String propertyName, int propertyCost, int utilityMortgage, boolean isChanceProperty, boolean isCommunityChestProperty, boolean isRailroadProperty, boolean isUtilityProperty, boolean isAProperty){
        name = propertyName;
        cost = propertyCost;
        isChance = isChanceProperty;
        isCommunityChest = isCommunityChestProperty;
        isUtility = isUtilityProperty;
        mortgage = utilityMortgage;
    }

    /***
     * Get payment for this property
     * if houses = 0 then that is rent without any houses
     * if houses = 1 then that is rent for 1 house
     * ...
     * if houses = 5 then that is rent for the hotel
     * @return rent or any other payment due
     */
    public int getPayment(){
        return rents[houses]; 
    }
    
    //make a payment for railraods, with a rent array same as properties.
    public int getRailroadPayment(){
        return railroadRent[currentPlayer].numOfRailroads]; 
    }

    public String toString(){
        return "Name: " + name +  " | Cost: " + cost +  " | Mortgage: " + mortgage + " | Houses: " + houses + " | House cost: " + houseCost + " | Rent with 0 houses: " + rents[0] + " | Rent with 1 house: " + rents[1]+ " | Rent with 2 houses: " + rents[2] + " | Rent with 3 houses: " + rents[3] + " | Rent with 4 houses: " + rents[4] + " | Rent with a hotel: " + rents[5] + " | Is owned: " + owned + " | Is community chest: " + isCommunityChest + " | Is chance: " + isChance; //+ " Owner: " + players[ownerIndex].name +
    }
    
}



