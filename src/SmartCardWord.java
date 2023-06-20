
import java.util.List;
import javax.smartcardio.*;

public class SmartCardWord {

    public static final byte[] AID_APPLET = {(byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x00};
    private Card card;
    private TerminalFactory factory;
    private CardChannel channel;
    private CardTerminal terminal;
    private List<CardTerminal> terminals;
    private ResponseAPDU response;

    public static void main(String[] args) {
        SmartCardWord check = new SmartCardWord();
        check.connectCard();
    }

    public boolean connectCard() {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("T=0");
            channel = card.getBasicChannel();
            if (channel == null) {
                return false;
            }
            response = channel.transmit(new CommandAPDU(0x00, (byte) 0xA4, 0x04, 0x00, AID_APPLET));
            String check = Integer.toHexString(response.getSW());
            if (check.equals("9000")) {
                System.out.println(check);
                return true;
            } else if (check.equals("6400")) {
                System.out.println(check);
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }

    }
}
