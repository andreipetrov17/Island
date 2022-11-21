package swing.printout;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

public class SwingOutput extends OutputStream {
    private final JTextArea textArea;

    public SwingOutput(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) throws IOException {
        write(new byte[] { (byte) b }, 0, 1);
    }

    @Override
    public void write(byte[] buffer, int offset, int length) throws IOException {
        final String text = new String(buffer, offset, length);
                textArea.append(text);
            }


}
