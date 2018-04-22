package therfc.bin.UI.components;

import therfc.bin.data.Warehouse;

import javax.swing.*;

public abstract class GraphicComponent extends JPanel {
    public abstract void Refresh(Warehouse wh);
}
