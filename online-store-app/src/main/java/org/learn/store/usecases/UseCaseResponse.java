package org.learn.store.usecases;

import java.util.ArrayList;
import java.util.List;

public abstract class UseCaseResponse {
  public boolean successful = true;
  public List<String> messages = new ArrayList<>();
}
