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

/**
 * The HighlightOptions controls how the data is fetched and returned.
 */
public class HighlightOptions implements org.apache.blur.thirdparty.thrift_0_9_0.TBase<HighlightOptions, HighlightOptions._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TStruct STRUCT_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TStruct("HighlightOptions");

  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField SIMPLE_QUERY_FIELD_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField("simpleQuery", org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRUCT, (short)1);
  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField PRE_TAG_FIELD_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField("preTag", org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING, (short)2);
  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField POST_TAG_FIELD_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField("postTag", org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new HighlightOptionsStandardSchemeFactory());
    schemes.put(TupleScheme.class, new HighlightOptionsTupleSchemeFactory());
  }

  /**
   * The original query is required if used in the Blur.fetchRow call.  If
   * the highlightOptions is used in a call to Blur.query then the SimpleQuery
   * passed into the call via the BlurQuery will be used if this simpleQuery is
   * null.  So that means if you use highlighting from the query call you can
   * leave this attribute null and it will default to the normal behavior.
   */
  public SimpleQuery simpleQuery; // required
  /**
   * The pre tag is the tag that marks the beginning of the highlighting.
   */
  public String preTag; // required
  /**
   * The post tag is the tag that marks the end of the highlighting.
   */
  public String postTag; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.blur.thirdparty.thrift_0_9_0.TFieldIdEnum {
    /**
     * The original query is required if used in the Blur.fetchRow call.  If
     * the highlightOptions is used in a call to Blur.query then the SimpleQuery
     * passed into the call via the BlurQuery will be used if this simpleQuery is
     * null.  So that means if you use highlighting from the query call you can
     * leave this attribute null and it will default to the normal behavior.
     */
    SIMPLE_QUERY((short)1, "simpleQuery"),
    /**
     * The pre tag is the tag that marks the beginning of the highlighting.
     */
    PRE_TAG((short)2, "preTag"),
    /**
     * The post tag is the tag that marks the end of the highlighting.
     */
    POST_TAG((short)3, "postTag");

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
        case 1: // SIMPLE_QUERY
          return SIMPLE_QUERY;
        case 2: // PRE_TAG
          return PRE_TAG;
        case 3: // POST_TAG
          return POST_TAG;
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

  // isset id assignments
  public static final Map<_Fields, org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SIMPLE_QUERY, new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData("simpleQuery", org.apache.blur.thirdparty.thrift_0_9_0.TFieldRequirementType.DEFAULT, 
        new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.StructMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRUCT, SimpleQuery.class)));
    tmpMap.put(_Fields.PRE_TAG, new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData("preTag", org.apache.blur.thirdparty.thrift_0_9_0.TFieldRequirementType.DEFAULT, 
        new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldValueMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING)));
    tmpMap.put(_Fields.POST_TAG, new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData("postTag", org.apache.blur.thirdparty.thrift_0_9_0.TFieldRequirementType.DEFAULT, 
        new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldValueMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData.addStructMetaDataMap(HighlightOptions.class, metaDataMap);
  }

  public HighlightOptions() {
    this.preTag = "<<<";

    this.postTag = ">>>";

  }

  public HighlightOptions(
    SimpleQuery simpleQuery,
    String preTag,
    String postTag)
  {
    this();
    this.simpleQuery = simpleQuery;
    this.preTag = preTag;
    this.postTag = postTag;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public HighlightOptions(HighlightOptions other) {
    if (other.isSetSimpleQuery()) {
      this.simpleQuery = new SimpleQuery(other.simpleQuery);
    }
    if (other.isSetPreTag()) {
      this.preTag = other.preTag;
    }
    if (other.isSetPostTag()) {
      this.postTag = other.postTag;
    }
  }

  public HighlightOptions deepCopy() {
    return new HighlightOptions(this);
  }

  @Override
  public void clear() {
    this.simpleQuery = null;
    this.preTag = "<<<";

    this.postTag = ">>>";

  }

  /**
   * The original query is required if used in the Blur.fetchRow call.  If
   * the highlightOptions is used in a call to Blur.query then the SimpleQuery
   * passed into the call via the BlurQuery will be used if this simpleQuery is
   * null.  So that means if you use highlighting from the query call you can
   * leave this attribute null and it will default to the normal behavior.
   */
  public SimpleQuery getSimpleQuery() {
    return this.simpleQuery;
  }

  /**
   * The original query is required if used in the Blur.fetchRow call.  If
   * the highlightOptions is used in a call to Blur.query then the SimpleQuery
   * passed into the call via the BlurQuery will be used if this simpleQuery is
   * null.  So that means if you use highlighting from the query call you can
   * leave this attribute null and it will default to the normal behavior.
   */
  public HighlightOptions setSimpleQuery(SimpleQuery simpleQuery) {
    this.simpleQuery = simpleQuery;
    return this;
  }

  public void unsetSimpleQuery() {
    this.simpleQuery = null;
  }

  /** Returns true if field simpleQuery is set (has been assigned a value) and false otherwise */
  public boolean isSetSimpleQuery() {
    return this.simpleQuery != null;
  }

  public void setSimpleQueryIsSet(boolean value) {
    if (!value) {
      this.simpleQuery = null;
    }
  }

  /**
   * The pre tag is the tag that marks the beginning of the highlighting.
   */
  public String getPreTag() {
    return this.preTag;
  }

  /**
   * The pre tag is the tag that marks the beginning of the highlighting.
   */
  public HighlightOptions setPreTag(String preTag) {
    this.preTag = preTag;
    return this;
  }

  public void unsetPreTag() {
    this.preTag = null;
  }

  /** Returns true if field preTag is set (has been assigned a value) and false otherwise */
  public boolean isSetPreTag() {
    return this.preTag != null;
  }

  public void setPreTagIsSet(boolean value) {
    if (!value) {
      this.preTag = null;
    }
  }

  /**
   * The post tag is the tag that marks the end of the highlighting.
   */
  public String getPostTag() {
    return this.postTag;
  }

  /**
   * The post tag is the tag that marks the end of the highlighting.
   */
  public HighlightOptions setPostTag(String postTag) {
    this.postTag = postTag;
    return this;
  }

  public void unsetPostTag() {
    this.postTag = null;
  }

  /** Returns true if field postTag is set (has been assigned a value) and false otherwise */
  public boolean isSetPostTag() {
    return this.postTag != null;
  }

  public void setPostTagIsSet(boolean value) {
    if (!value) {
      this.postTag = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SIMPLE_QUERY:
      if (value == null) {
        unsetSimpleQuery();
      } else {
        setSimpleQuery((SimpleQuery)value);
      }
      break;

    case PRE_TAG:
      if (value == null) {
        unsetPreTag();
      } else {
        setPreTag((String)value);
      }
      break;

    case POST_TAG:
      if (value == null) {
        unsetPostTag();
      } else {
        setPostTag((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SIMPLE_QUERY:
      return getSimpleQuery();

    case PRE_TAG:
      return getPreTag();

    case POST_TAG:
      return getPostTag();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SIMPLE_QUERY:
      return isSetSimpleQuery();
    case PRE_TAG:
      return isSetPreTag();
    case POST_TAG:
      return isSetPostTag();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof HighlightOptions)
      return this.equals((HighlightOptions)that);
    return false;
  }

  public boolean equals(HighlightOptions that) {
    if (that == null)
      return false;

    boolean this_present_simpleQuery = true && this.isSetSimpleQuery();
    boolean that_present_simpleQuery = true && that.isSetSimpleQuery();
    if (this_present_simpleQuery || that_present_simpleQuery) {
      if (!(this_present_simpleQuery && that_present_simpleQuery))
        return false;
      if (!this.simpleQuery.equals(that.simpleQuery))
        return false;
    }

    boolean this_present_preTag = true && this.isSetPreTag();
    boolean that_present_preTag = true && that.isSetPreTag();
    if (this_present_preTag || that_present_preTag) {
      if (!(this_present_preTag && that_present_preTag))
        return false;
      if (!this.preTag.equals(that.preTag))
        return false;
    }

    boolean this_present_postTag = true && this.isSetPostTag();
    boolean that_present_postTag = true && that.isSetPostTag();
    if (this_present_postTag || that_present_postTag) {
      if (!(this_present_postTag && that_present_postTag))
        return false;
      if (!this.postTag.equals(that.postTag))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(HighlightOptions other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    HighlightOptions typedOther = (HighlightOptions)other;

    lastComparison = Boolean.valueOf(isSetSimpleQuery()).compareTo(typedOther.isSetSimpleQuery());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSimpleQuery()) {
      lastComparison = org.apache.blur.thirdparty.thrift_0_9_0.TBaseHelper.compareTo(this.simpleQuery, typedOther.simpleQuery);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPreTag()).compareTo(typedOther.isSetPreTag());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPreTag()) {
      lastComparison = org.apache.blur.thirdparty.thrift_0_9_0.TBaseHelper.compareTo(this.preTag, typedOther.preTag);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPostTag()).compareTo(typedOther.isSetPostTag());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPostTag()) {
      lastComparison = org.apache.blur.thirdparty.thrift_0_9_0.TBaseHelper.compareTo(this.postTag, typedOther.postTag);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol iprot) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol oprot) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("HighlightOptions(");
    boolean first = true;

    sb.append("simpleQuery:");
    if (this.simpleQuery == null) {
      sb.append("null");
    } else {
      sb.append(this.simpleQuery);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("preTag:");
    if (this.preTag == null) {
      sb.append("null");
    } else {
      sb.append(this.preTag);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("postTag:");
    if (this.postTag == null) {
      sb.append("null");
    } else {
      sb.append(this.postTag);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
    // check for required fields
    // check for sub-struct validity
    if (simpleQuery != null) {
      simpleQuery.validate();
    }
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

  private static class HighlightOptionsStandardSchemeFactory implements SchemeFactory {
    public HighlightOptionsStandardScheme getScheme() {
      return new HighlightOptionsStandardScheme();
    }
  }

  private static class HighlightOptionsStandardScheme extends StandardScheme<HighlightOptions> {

    public void read(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol iprot, HighlightOptions struct) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
      org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SIMPLE_QUERY
            if (schemeField.type == org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRUCT) {
              struct.simpleQuery = new SimpleQuery();
              struct.simpleQuery.read(iprot);
              struct.setSimpleQueryIsSet(true);
            } else { 
              org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PRE_TAG
            if (schemeField.type == org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING) {
              struct.preTag = iprot.readString();
              struct.setPreTagIsSet(true);
            } else { 
              org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // POST_TAG
            if (schemeField.type == org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING) {
              struct.postTag = iprot.readString();
              struct.setPostTagIsSet(true);
            } else { 
              org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol oprot, HighlightOptions struct) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.simpleQuery != null) {
        oprot.writeFieldBegin(SIMPLE_QUERY_FIELD_DESC);
        struct.simpleQuery.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.preTag != null) {
        oprot.writeFieldBegin(PRE_TAG_FIELD_DESC);
        oprot.writeString(struct.preTag);
        oprot.writeFieldEnd();
      }
      if (struct.postTag != null) {
        oprot.writeFieldBegin(POST_TAG_FIELD_DESC);
        oprot.writeString(struct.postTag);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class HighlightOptionsTupleSchemeFactory implements SchemeFactory {
    public HighlightOptionsTupleScheme getScheme() {
      return new HighlightOptionsTupleScheme();
    }
  }

  private static class HighlightOptionsTupleScheme extends TupleScheme<HighlightOptions> {

    @Override
    public void write(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol prot, HighlightOptions struct) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSimpleQuery()) {
        optionals.set(0);
      }
      if (struct.isSetPreTag()) {
        optionals.set(1);
      }
      if (struct.isSetPostTag()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetSimpleQuery()) {
        struct.simpleQuery.write(oprot);
      }
      if (struct.isSetPreTag()) {
        oprot.writeString(struct.preTag);
      }
      if (struct.isSetPostTag()) {
        oprot.writeString(struct.postTag);
      }
    }

    @Override
    public void read(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol prot, HighlightOptions struct) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.simpleQuery = new SimpleQuery();
        struct.simpleQuery.read(iprot);
        struct.setSimpleQueryIsSet(true);
      }
      if (incoming.get(1)) {
        struct.preTag = iprot.readString();
        struct.setPreTagIsSet(true);
      }
      if (incoming.get(2)) {
        struct.postTag = iprot.readString();
        struct.setPostTagIsSet(true);
      }
    }
  }

}

