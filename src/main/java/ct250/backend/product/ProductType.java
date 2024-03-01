package ct250.backend.product;

import java.util.HashMap;
import java.util.Map;

public enum ProductType {
    SHIRTS,
    PANTS,
    DRESSES,
    SHOES,
    JACKETS,
    JEWELRY,
    ACCESSORIES,
    SWEATERS,
    JEANS,
    SHORTS,
    SKIRTS,
    BLOUSES,
    T_SHIRTS,
    ACTIVEWEAR,
    SOCKS,
    SCARVES,
    SUNGLASSES,
    WATCHES,
    HATS_CAPS,
    BELTS,
    GLOVES,
    WALLETS,
    PERFUMES,
    MAKEUP_COSMETICS,
    HAIR_ACCESSORIES,
    BACKPACKS,
    FORMAL_WEAR,
    OTHER;

    private static final Map<String, ProductType> stringToEnum = new HashMap<>();

    static {
        for (ProductType productType : values()) {
            stringToEnum.put(productType.name(), productType);
        }
    }

    public static ProductType fromString(String value) {
        return stringToEnum.get(value);
    }
}
