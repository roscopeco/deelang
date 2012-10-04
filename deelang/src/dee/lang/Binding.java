package dee.lang;

public interface Binding {
  public Object getLocal(String name);
  public void setLocal(String name, Object value);
  public DeelangObject getSelf();
  public void setErrorFlag();  
}
