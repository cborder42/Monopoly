public class Property {
    // member variables
    private String name;
    private int cost;
    private int houses;
    private int mortgage;
    private int houseCost;
    private int ownerIndex;
    private boolean owned;
    private boolean isChance;
    private boolean isCommunityChest;
    private boolean isUtility;
    private int[] rents = new int[6];
    //make railroad rent array
    //make a variable isProperty

    //constructor
    public Property(String propertyName, int propertyCost, int propertyMortgage, int propertyHouseCost, int[] propertyRents, boolean isChanceProperty, boolean isCommunityChestProperty){
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
    public Property(String propertyName, boolean isChanceProperty, boolean isCommunityChestProperty){
        name = propertyName;
        isChance = isChanceProperty;
        isCommunityChest = isCommunityChestProperty;
    }
    public Property(String propertyName, int propertyCost, boolean isChanceProperty, boolean isCommunityChestProperty){
        name = propertyName;
        cost = propertyCost;
        isChance = isChanceProperty;
        isCommunityChest = isCommunityChestProperty;
    }
    public Property(String propertyName, int propertyCost, boolean isChanceProperty, boolean isCommunityChestProperty, boolean isUtilityProperty){
        name = propertyName;
        cost = propertyCost;
        isChance = isChanceProperty;
        isCommunityChest = isCommunityChestProperty;
        isUtility = isUtilityProperty;
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

    public String toString(){
        return "Name: " + name +  " | Cost: " + cost +  " | Mortgage: " + mortgage + " | Houses: " + houses + " | House cost: " + houseCost + " | Rent with 0 houses: " + rents[0] + " | Rent with 1 house: " + rents[1]+ " | Rent with 2 houses: " + rents[2] + " | Rent with 3 houses: " + rents[3] + " | Rent with 4 houses: " + rents[4] + " | Rent with a hotel: " + rents[5] + " | Is owned: " + owned + " | Is community chest: " + isCommunityChest + " | Is chance: " + isChance; //+ " Owner: " + players[ownerIndex].name +
    }
    
}



