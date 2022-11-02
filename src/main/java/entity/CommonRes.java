package entity;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class CommonRes {
    public AtomicReferenceArray<Population> value;
    public CommonRes(ArrayList<Population> list) {
        value = new AtomicReferenceArray<>(list.size());
        for (int i = 0; i < list.size(); i++) {
            value.set(i, list.get(i));
        }
    }
}
