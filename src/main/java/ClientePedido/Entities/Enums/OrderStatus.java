package ClientePedido.Entities.Enums;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    // Código do tipo enumerado
    private int code;

    // Construtor para o código do tipo enumerado
    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    // Metodo para transformar valor numérico em tipo enumerado
    public static OrderStatus valueOf(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid code");
    }
}
