package Desafio_3;

import java.util.Date;

public class Consumidor extends Thread {

    private final Buffer buffer;
    private final int id;

    public Consumidor(Buffer buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        boolean processamento = true;

        while (processamento) {

            Pedido pedido = null;
            try {
                pedido = buffer.removePedido((long) id);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            if (pedido != null) {
                pedido.getLog().setIdConsumidor((long) id);
            }
            try {

                Thread.sleep(3000);

            } catch (InterruptedException e) {
                System.out.println(e);
            }

            if (pedido != null) {
                pedido.getLog().setHoraFinal(new Date());
                buffer.imprimePedido(pedido);
            }
        }
    }
}
