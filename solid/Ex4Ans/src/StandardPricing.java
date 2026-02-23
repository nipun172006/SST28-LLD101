import java.util.*;

class StandardRoomPricing implements RoomPriceCalculator {
    private final Map<Integer, Double> prices = new HashMap<>();

    public StandardRoomPricing() {
        prices.put(LegacyRoomTypes.SINGLE, 14000.0);
        prices.put(LegacyRoomTypes.DOUBLE, 15000.0);
        prices.put(LegacyRoomTypes.TRIPLE, 12000.0);
    }

    @Override
    public double getPrice(int roomType) {
        return prices.getOrDefault(roomType, 16000.0);
    }
}

class StandardAddOnPricing implements AddOnPriceCalculator {
    private final Map<AddOn, Double> prices = new EnumMap<>(AddOn.class);

    public StandardAddOnPricing() {
        prices.put(AddOn.MESS, 1000.0);
        prices.put(AddOn.LAUNDRY, 500.0);
        prices.put(AddOn.GYM, 300.0);
    }

    @Override
    public double getPrice(AddOn addOn) {
        return prices.getOrDefault(addOn, 0.0);
    }
}
