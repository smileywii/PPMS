package ppms;

import java.util.LinkedList;
import java.util.List;

import org.mockito.internal.listeners.CollectCreatedMocks;
import org.mockito.internal.progress.ThreadSafeMockingProgress;

public class MocksCollector {
  private final List<Object> createdMocks = new LinkedList<>();

  public MocksCollector() {
    new ThreadSafeMockingProgress().setListener(new CollectCreatedMocks(createdMocks));
  }

  public Object[] getMocks() {
    return createdMocks.toArray();
  }
}