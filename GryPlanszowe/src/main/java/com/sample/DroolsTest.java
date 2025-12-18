package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import javax.swing.JFrame;	

public class DroolsTest {

    public static void main(String[] args) {
        try {
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            JFrame frame = new JFrame("Game Recommender");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            GuiHelper myHelper = new GuiHelper(frame);

            kSession.setGlobal("helper", myHelper);
            kSession.fireAllRules();

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}