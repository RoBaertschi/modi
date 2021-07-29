package com.robinb.modi.gui;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;

public class ExampleGui extends LightweightGuiDescription {
    public ExampleGui(int kills) {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(300, 200);

        WLabel label = new WLabel("Hello World");
        WLabel lable2 = new WLabel(String.valueOf(kills));
        root.add(label, 5, 1);
        root.add(lable2, 5, 2);
    }
}
