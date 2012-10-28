package dee.lang;

/**
 * A Deelang boolean. 
 * <br/>
 * {@code DeelangBoolean}s cannot be instantiated directly. Instead,
 * each {@link Binding} holds two instances, representing TRUE
 * and FALSE respectively.
 * 
 * @author rosco
 * @created 18th October 2012
 */
public final class DeelangBoolean extends DeelangObject {
  private final boolean value;
  
  DeelangBoolean(Binding binding, boolean value) {
    super(binding);
    this.value = value;
  }
  
  public boolean getBoolean() {
    return value;
  }

  @Override
  public DeelangBoolean __opEQL(DeelangObject other) {
    return binding.wrapBool(this.value == other.toB().value);
  }

  @Override
  public DeelangObject __opNOT() {
    return value ? binding.FALSE : binding.TRUE;
  }

  @Override
  public DeelangString toS() {
    return value ? binding.wrapStr("true") : binding.wrapStr("false");
    
  }

  @Override
  public DeelangInteger toI() {
    return value ? new DeelangInteger(binding, 1) : new DeelangInteger(binding, 0);
  }

  @Override
  public DeelangFloat toF() {
    return value ? new DeelangFloat(binding, 1.0) : new DeelangFloat(binding, 0.0);
  }

  @Override
  public DeelangBoolean toB() {
    return this;
  }
  
  /**
   * Override equality. In DeelangBoolean, equality is implemented
   * directly. This is implemented for convenience when used from Java.
   */
  @Override
  public boolean equals(Object other) {
    if (other instanceof DeelangBoolean) {
      return this.value == ((DeelangBoolean) other).value;
    } else if (other instanceof DeelangObject) {
      return this.value == ((DeelangBoolean) other).toB().value;
    } else {
      return false;
    } 
  }  
}
