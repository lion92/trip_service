package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class GildedRoseTest {

    @Test
    void foo() {
        ByteArrayOutputStream log = new ByteArrayOutputStream();
        System.setOut(new PrintStream(log));
        TexttestFixture.main(new String[]{"50"});
        Approvals.verify(log);
    }

}
