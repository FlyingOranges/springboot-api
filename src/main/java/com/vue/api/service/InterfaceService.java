package com.vue.api.service;

import java.io.IOException;
import java.util.HashMap;

public interface InterfaceService {

    Integer createData(HashMap<String, Object> params) throws IOException;

}
