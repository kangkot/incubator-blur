/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.blur.thrift.generated;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



import org.apache.blur.thirdparty.thrift_0_9_0.scheme.IScheme;
import org.apache.blur.thirdparty.thrift_0_9_0.scheme.SchemeFactory;
import org.apache.blur.thirdparty.thrift_0_9_0.scheme.StandardScheme;

import org.apache.blur.thirdparty.thrift_0_9_0.scheme.TupleScheme;
import org.apache.blur.thirdparty.thrift_0_9_0.protocol.TTupleProtocol;
import org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolException;
import org.apache.blur.thirdparty.thrift_0_9_0.EncodingUtils;
import org.apache.blur.thirdparty.thrift_0_9_0.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class ValueObject extends org.apache.blur.thirdparty.thrift_0_9_0.TUnion<ValueObject, ValueObject._Fields> {
  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TStruct STRUCT_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TStruct("ValueObject");
  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField VALUE_FIELD_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField("value", org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRUCT, (short)1);
  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField BLUR_OBJECT_FIELD_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField("blurObject", org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.LIST, (short)2);

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.blur.thirdparty.thrift_0_9_0.TFieldIdEnum {
    VALUE((short)1, "value"),
    BLUR_OBJECT((short)2, "blurObject");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // VALUE
          return VALUE;
        case 2: // BLUR_OBJECT
          return BLUR_OBJECT;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  public static final Map<_Fields, org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.VALUE, new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData("value", org.apache.blur.thirdparty.thrift_0_9_0.TFieldRequirementType.DEFAULT, 
        new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.StructMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRUCT, Value.class)));
    tmpMap.put(_Fields.BLUR_OBJECT, new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData("blurObject", org.apache.blur.thirdparty.thrift_0_9_0.TFieldRequirementType.DEFAULT, 
        new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.ListMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.LIST, 
            new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.StructMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRUCT, BlurPackedObject.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData.addStructMetaDataMap(ValueObject.class, metaDataMap);
  }

  public ValueObject() {
    super();
  }

  public ValueObject(_Fields setField, Object value) {
    super(setField, value);
  }

  public ValueObject(ValueObject other) {
    super(other);
  }
  public ValueObject deepCopy() {
    return new ValueObject(this);
  }

  public static ValueObject value(Value value) {
    ValueObject x = new ValueObject();
    x.setValue(value);
    return x;
  }

  public static ValueObject blurObject(List<BlurPackedObject> value) {
    ValueObject x = new ValueObject();
    x.setBlurObject(value);
    return x;
  }


  @Override
  protected void checkType(_Fields setField, Object value) throws ClassCastException {
    switch (setField) {
      case VALUE:
        if (value instanceof Value) {
          break;
        }
        throw new ClassCastException("Was expecting value of type Value for field 'value', but got " + value.getClass().getSimpleName());
      case BLUR_OBJECT:
        if (value instanceof List) {
          break;
        }
        throw new ClassCastException("Was expecting value of type List<BlurPackedObject> for field 'blurObject', but got " + value.getClass().getSimpleName());
      default:
        throw new IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected Object standardSchemeReadValue(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol iprot, org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField field) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
    _Fields setField = _Fields.findByThriftId(field.id);
    if (setField != null) {
      switch (setField) {
        case VALUE:
          if (field.type == VALUE_FIELD_DESC.type) {
            Value value;
            value = new Value();
            value.read(iprot);
            return value;
          } else {
            org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case BLUR_OBJECT:
          if (field.type == BLUR_OBJECT_FIELD_DESC.type) {
            List<BlurPackedObject> blurObject;
            {
              org.apache.blur.thirdparty.thrift_0_9_0.protocol.TList _list232 = iprot.readListBegin();
              blurObject = new ArrayList<BlurPackedObject>(_list232.size);
              for (int _i233 = 0; _i233 < _list232.size; ++_i233)
              {
                BlurPackedObject _elem234; // required
                _elem234 = new BlurPackedObject();
                _elem234.read(iprot);
                blurObject.add(_elem234);
              }
              iprot.readListEnd();
            }
            return blurObject;
          } else {
            org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        default:
          throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      return null;
    }
  }

  @Override
  protected void standardSchemeWriteValue(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol oprot) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
    switch (setField_) {
      case VALUE:
        Value value = (Value)value_;
        value.write(oprot);
        return;
      case BLUR_OBJECT:
        List<BlurPackedObject> blurObject = (List<BlurPackedObject>)value_;
        {
          oprot.writeListBegin(new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TList(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRUCT, blurObject.size()));
          for (BlurPackedObject _iter235 : blurObject)
          {
            _iter235.write(oprot);
          }
          oprot.writeListEnd();
        }
        return;
      default:
        throw new IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected Object tupleSchemeReadValue(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol iprot, short fieldID) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
    _Fields setField = _Fields.findByThriftId(fieldID);
    if (setField != null) {
      switch (setField) {
        case VALUE:
          Value value;
          value = new Value();
          value.read(iprot);
          return value;
        case BLUR_OBJECT:
          List<BlurPackedObject> blurObject;
          {
            org.apache.blur.thirdparty.thrift_0_9_0.protocol.TList _list236 = iprot.readListBegin();
            blurObject = new ArrayList<BlurPackedObject>(_list236.size);
            for (int _i237 = 0; _i237 < _list236.size; ++_i237)
            {
              BlurPackedObject _elem238; // required
              _elem238 = new BlurPackedObject();
              _elem238.read(iprot);
              blurObject.add(_elem238);
            }
            iprot.readListEnd();
          }
          return blurObject;
        default:
          throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      throw new TProtocolException("Couldn't find a field with field id " + fieldID);
    }
  }

  @Override
  protected void tupleSchemeWriteValue(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol oprot) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
    switch (setField_) {
      case VALUE:
        Value value = (Value)value_;
        value.write(oprot);
        return;
      case BLUR_OBJECT:
        List<BlurPackedObject> blurObject = (List<BlurPackedObject>)value_;
        {
          oprot.writeListBegin(new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TList(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRUCT, blurObject.size()));
          for (BlurPackedObject _iter239 : blurObject)
          {
            _iter239.write(oprot);
          }
          oprot.writeListEnd();
        }
        return;
      default:
        throw new IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField getFieldDesc(_Fields setField) {
    switch (setField) {
      case VALUE:
        return VALUE_FIELD_DESC;
      case BLUR_OBJECT:
        return BLUR_OBJECT_FIELD_DESC;
      default:
        throw new IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected org.apache.blur.thirdparty.thrift_0_9_0.protocol.TStruct getStructDesc() {
    return STRUCT_DESC;
  }

  @Override
  protected _Fields enumForId(short id) {
    return _Fields.findByThriftIdOrThrow(id);
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }


  public Value getValue() {
    if (getSetField() == _Fields.VALUE) {
      return (Value)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'value' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setValue(Value value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.VALUE;
    value_ = value;
  }

  public List<BlurPackedObject> getBlurObject() {
    if (getSetField() == _Fields.BLUR_OBJECT) {
      return (List<BlurPackedObject>)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'blurObject' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setBlurObject(List<BlurPackedObject> value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.BLUR_OBJECT;
    value_ = value;
  }

  public boolean isSetValue() {
    return setField_ == _Fields.VALUE;
  }


  public boolean isSetBlurObject() {
    return setField_ == _Fields.BLUR_OBJECT;
  }


  public boolean equals(Object other) {
    if (other instanceof ValueObject) {
      return equals((ValueObject)other);
    } else {
      return false;
    }
  }

  public boolean equals(ValueObject other) {
    return other != null && getSetField() == other.getSetField() && getFieldValue().equals(other.getFieldValue());
  }

  @Override
  public int compareTo(ValueObject other) {
    int lastComparison = org.apache.blur.thirdparty.thrift_0_9_0.TBaseHelper.compareTo(getSetField(), other.getSetField());
    if (lastComparison == 0) {
      return org.apache.blur.thirdparty.thrift_0_9_0.TBaseHelper.compareTo(getFieldValue(), other.getFieldValue());
    }
    return lastComparison;
  }


  /**
   * If you'd like this to perform more respectably, use the hashcode generator option.
   */
  @Override
  public int hashCode() {
    return 0;
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TCompactProtocol(new org.apache.blur.thirdparty.thrift_0_9_0.transport.TIOStreamTransport(out)));
    } catch (org.apache.blur.thirdparty.thrift_0_9_0.TException te) {
      throw new java.io.IOException(te);
    }
  }


  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TCompactProtocol(new org.apache.blur.thirdparty.thrift_0_9_0.transport.TIOStreamTransport(in)));
    } catch (org.apache.blur.thirdparty.thrift_0_9_0.TException te) {
      throw new java.io.IOException(te);
    }
  }


}
