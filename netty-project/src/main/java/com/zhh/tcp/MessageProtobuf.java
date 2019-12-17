package com.zhh.tcp;

/**
 * @author
 * @package com.zhh.tcp
 * @description
 * @create 2019-12-17 10:14
 **/
public  final class MessageProtobuf {
    private MessageProtobuf() {}
    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }
    public interface MsgOrBuilder extends
            // @@protoc_insertion_point(interface_extends:Msg)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <pre>
         * ��Ϣͷ
         * </pre>
         *
         * <code>.Head head = 1;</code>
         */
        boolean hasHead();
        /**
         * <pre>
         * ��Ϣͷ
         * </pre>
         *
         * <code>.Head head = 1;</code>
         */
        Head getHead();
        /**
         * <pre>
         * ��Ϣͷ
         * </pre>
         *
         * <code>.Head head = 1;</code>
         */
        HeadOrBuilder getHeadOrBuilder();

        /**
         * <pre>
         * ��Ϣ��
         * </pre>
         *
         * <code>string body = 2;</code>
         */
        String getBody();
        /**
         * <pre>
         * ��Ϣ��
         * </pre>
         *
         * <code>string body = 2;</code>
         */
        com.google.protobuf.ByteString
        getBodyBytes();
    }
    /**
     * Protobuf type {@code Msg}
     */
    public  static final class Msg extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:Msg)
            MsgOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use Msg.newBuilder() to construct.
        private Msg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private Msg() {
            body_ = "";
        }

        @Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private Msg(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {
                            Head.Builder subBuilder = null;
                            if (head_ != null) {
                                subBuilder = head_.toBuilder();
                            }
                            head_ = input.readMessage(Head.parser(), extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(head_);
                                head_ = subBuilder.buildPartial();
                            }

                            break;
                        }
                        case 18: {
                            String s = input.readStringRequireUtf8();

                            body_ = s;
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return MessageProtobuf.internal_static_Msg_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return MessageProtobuf.internal_static_Msg_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            Msg.class, Builder.class);
        }

        public static final int HEAD_FIELD_NUMBER = 1;
        private Head head_;
        /**
         * <pre>
         * ��Ϣͷ
         * </pre>
         *
         * <code>.Head head = 1;</code>
         */
        public boolean hasHead() {
            return head_ != null;
        }
        /**
         * <pre>
         * ��Ϣͷ
         * </pre>
         *
         * <code>.Head head = 1;</code>
         */
        public Head getHead() {
            return head_ == null ? Head.getDefaultInstance() : head_;
        }
        /**
         * <pre>
         * ��Ϣͷ
         * </pre>
         *
         * <code>.Head head = 1;</code>
         */
        public HeadOrBuilder getHeadOrBuilder() {
            return getHead();
        }

        public static final int BODY_FIELD_NUMBER = 2;
        private volatile Object body_;
        /**
         * <pre>
         * ��Ϣ��
         * </pre>
         *
         * <code>string body = 2;</code>
         */
        public String getBody() {
            Object ref = body_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                body_ = s;
                return s;
            }
        }
        /**
         * <pre>
         * ��Ϣ��
         * </pre>
         *
         * <code>string body = 2;</code>
         */
        public com.google.protobuf.ByteString
        getBodyBytes() {
            Object ref = body_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (String) ref);
                body_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (head_ != null) {
                output.writeMessage(1, getHead());
            }
            if (!getBodyBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 2, body_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (head_ != null) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(1, getHead());
            }
            if (!getBodyBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, body_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Msg)) {
                return super.equals(obj);
            }
            Msg other = (Msg) obj;

            boolean result = true;
            result = result && (hasHead() == other.hasHead());
            if (hasHead()) {
                result = result && getHead()
                        .equals(other.getHead());
            }
            result = result && getBody()
                    .equals(other.getBody());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasHead()) {
                hash = (37 * hash) + HEAD_FIELD_NUMBER;
                hash = (53 * hash) + getHead().hashCode();
            }
            hash = (37 * hash) + BODY_FIELD_NUMBER;
            hash = (53 * hash) + getBody().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static Msg parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static Msg parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static Msg parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static Msg parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static Msg parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static Msg parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static Msg parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static Msg parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static Msg parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static Msg parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static Msg parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static Msg parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(Msg prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code Msg}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:Msg)
                MsgOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return MessageProtobuf.internal_static_Msg_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return MessageProtobuf.internal_static_Msg_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                Msg.class, Builder.class);
            }

            // Construct using com.freddy.im.protobuf.MessageProtobuf.Msg.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                if (headBuilder_ == null) {
                    head_ = null;
                } else {
                    head_ = null;
                    headBuilder_ = null;
                }
                body_ = "";

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return MessageProtobuf.internal_static_Msg_descriptor;
            }

            public Msg getDefaultInstanceForType() {
                return Msg.getDefaultInstance();
            }

            public Msg build() {
                Msg result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public Msg buildPartial() {
                Msg result = new Msg(this);
                if (headBuilder_ == null) {
                    result.head_ = head_;
                } else {
                    result.head_ = headBuilder_.build();
                }
                result.body_ = body_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof Msg) {
                    return mergeFrom((Msg)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(Msg other) {
                if (other == Msg.getDefaultInstance()) return this;
                if (other.hasHead()) {
                    mergeHead(other.getHead());
                }
                if (!other.getBody().isEmpty()) {
                    body_ = other.body_;
                    onChanged();
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                Msg parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (Msg) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private Head head_ = null;
            private com.google.protobuf.SingleFieldBuilderV3<
                    Head, Head.Builder, HeadOrBuilder> headBuilder_;
            /**
             * <pre>
             * ��Ϣͷ
             * </pre>
             *
             * <code>.Head head = 1;</code>
             */
            public boolean hasHead() {
                return headBuilder_ != null || head_ != null;
            }
            /**
             * <pre>
             * ��Ϣͷ
             * </pre>
             *
             * <code>.Head head = 1;</code>
             */
            public Head getHead() {
                if (headBuilder_ == null) {
                    return head_ == null ? Head.getDefaultInstance() : head_;
                } else {
                    return headBuilder_.getMessage();
                }
            }
            /**
             * <pre>
             * ��Ϣͷ
             * </pre>
             *
             * <code>.Head head = 1;</code>
             */
            public Builder setHead(Head value) {
                if (headBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    head_ = value;
                    onChanged();
                } else {
                    headBuilder_.setMessage(value);
                }

                return this;
            }
            /**
             * <pre>
             * ��Ϣͷ
             * </pre>
             *
             * <code>.Head head = 1;</code>
             */
            public Builder setHead(
                    Head.Builder builderForValue) {
                if (headBuilder_ == null) {
                    head_ = builderForValue.build();
                    onChanged();
                } else {
                    headBuilder_.setMessage(builderForValue.build());
                }

                return this;
            }
            /**
             * <pre>
             * ��Ϣͷ
             * </pre>
             *
             * <code>.Head head = 1;</code>
             */
            public Builder mergeHead(Head value) {
                if (headBuilder_ == null) {
                    if (head_ != null) {
                        head_ =
                                Head.newBuilder(head_).mergeFrom(value).buildPartial();
                    } else {
                        head_ = value;
                    }
                    onChanged();
                } else {
                    headBuilder_.mergeFrom(value);
                }

                return this;
            }
            /**
             * <pre>
             * ��Ϣͷ
             * </pre>
             *
             * <code>.Head head = 1;</code>
             */
            public Builder clearHead() {
                if (headBuilder_ == null) {
                    head_ = null;
                    onChanged();
                } else {
                    head_ = null;
                    headBuilder_ = null;
                }

                return this;
            }
            /**
             * <pre>
             * ��Ϣͷ
             * </pre>
             *
             * <code>.Head head = 1;</code>
             */
            public Head.Builder getHeadBuilder() {

                onChanged();
                return getHeadFieldBuilder().getBuilder();
            }
            /**
             * <pre>
             * ��Ϣͷ
             * </pre>
             *
             * <code>.Head head = 1;</code>
             */
            public HeadOrBuilder getHeadOrBuilder() {
                if (headBuilder_ != null) {
                    return headBuilder_.getMessageOrBuilder();
                } else {
                    return head_ == null ?
                            Head.getDefaultInstance() : head_;
                }
            }
            /**
             * <pre>
             * ��Ϣͷ
             * </pre>
             *
             * <code>.Head head = 1;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    Head, Head.Builder, HeadOrBuilder>
            getHeadFieldBuilder() {
                if (headBuilder_ == null) {
                    headBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            Head, Head.Builder, HeadOrBuilder>(
                            getHead(),
                            getParentForChildren(),
                            isClean());
                    head_ = null;
                }
                return headBuilder_;
            }

            private Object body_ = "";
            /**
             * <pre>
             * ��Ϣ��
             * </pre>
             *
             * <code>string body = 2;</code>
             */
            public String getBody() {
                Object ref = body_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    body_ = s;
                    return s;
                } else {
                    return (String) ref;
                }
            }
            /**
             * <pre>
             * ��Ϣ��
             * </pre>
             *
             * <code>string body = 2;</code>
             */
            public com.google.protobuf.ByteString
            getBodyBytes() {
                Object ref = body_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (String) ref);
                    body_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <pre>
             * ��Ϣ��
             * </pre>
             *
             * <code>string body = 2;</code>
             */
            public Builder setBody(
                    String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                body_ = value;
                onChanged();
                return this;
            }
            /**
             * <pre>
             * ��Ϣ��
             * </pre>
             *
             * <code>string body = 2;</code>
             */
            public Builder clearBody() {

                body_ = getDefaultInstance().getBody();
                onChanged();
                return this;
            }
            /**
             * <pre>
             * ��Ϣ��
             * </pre>
             *
             * <code>string body = 2;</code>
             */
            public Builder setBodyBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                body_ = value;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:Msg)
        }

        // @@protoc_insertion_point(class_scope:Msg)
        private static final Msg DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new Msg();
        }

        public static Msg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<Msg>
                PARSER = new com.google.protobuf.AbstractParser<Msg>() {
            public Msg parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new Msg(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<Msg> parser() {
            return PARSER;
        }

        @Override
        public com.google.protobuf.Parser<Msg> getParserForType() {
            return PARSER;
        }

        public Msg getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface HeadOrBuilder extends
            // @@protoc_insertion_point(interface_extends:Head)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <pre>
         * ��Ϣid
         * </pre>
         *
         * <code>string msgId = 1;</code>
         */
        String getMsgId();
        /**
         * <pre>
         * ��Ϣid
         * </pre>
         *
         * <code>string msgId = 1;</code>
         */
        com.google.protobuf.ByteString
        getMsgIdBytes();

        /**
         * <pre>
         * ��Ϣ����
         * </pre>
         *
         * <code>int32 msgType = 2;</code>
         */
        int getMsgType();

        /**
         * <pre>
         * ��Ϣ��������
         * </pre>
         *
         * <code>int32 msgContentType = 3;</code>
         */
        int getMsgContentType();

        /**
         * <pre>
         * ��Ϣ������id
         * </pre>
         *
         * <code>string fromId = 4;</code>
         */
        String getFromId();
        /**
         * <pre>
         * ��Ϣ������id
         * </pre>
         *
         * <code>string fromId = 4;</code>
         */
        com.google.protobuf.ByteString
        getFromIdBytes();

        /**
         * <pre>
         * ��Ϣ������id
         * </pre>
         *
         * <code>string toId = 5;</code>
         */
        String getToId();
        /**
         * <pre>
         * ��Ϣ������id
         * </pre>
         *
         * <code>string toId = 5;</code>
         */
        com.google.protobuf.ByteString
        getToIdBytes();

        /**
         * <pre>
         * ��Ϣʱ���
         * </pre>
         *
         * <code>int64 timestamp = 6;</code>
         */
        long getTimestamp();

        /**
         * <pre>
         * ״̬����
         * </pre>
         *
         * <code>int32 statusReport = 7;</code>
         */
        int getStatusReport();

        /**
         * <pre>
         * ��չ�ֶΣ���key/value��ʽ��ŵ�json
         * </pre>
         *
         * <code>string extend = 8;</code>
         */
        String getExtend();
        /**
         * <pre>
         * ��չ�ֶΣ���key/value��ʽ��ŵ�json
         * </pre>
         *
         * <code>string extend = 8;</code>
         */
        com.google.protobuf.ByteString
        getExtendBytes();
    }
    /**
     * Protobuf type {@code Head}
     */
    public  static final class Head extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:Head)
            HeadOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use Head.newBuilder() to construct.
        private Head(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private Head() {
            msgId_ = "";
            msgType_ = 0;
            msgContentType_ = 0;
            fromId_ = "";
            toId_ = "";
            timestamp_ = 0L;
            statusReport_ = 0;
            extend_ = "";
        }

        @Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private Head(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {
                            String s = input.readStringRequireUtf8();

                            msgId_ = s;
                            break;
                        }
                        case 16: {

                            msgType_ = input.readInt32();
                            break;
                        }
                        case 24: {

                            msgContentType_ = input.readInt32();
                            break;
                        }
                        case 34: {
                            String s = input.readStringRequireUtf8();

                            fromId_ = s;
                            break;
                        }
                        case 42: {
                            String s = input.readStringRequireUtf8();

                            toId_ = s;
                            break;
                        }
                        case 48: {

                            timestamp_ = input.readInt64();
                            break;
                        }
                        case 56: {

                            statusReport_ = input.readInt32();
                            break;
                        }
                        case 66: {
                            String s = input.readStringRequireUtf8();

                            extend_ = s;
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return MessageProtobuf.internal_static_Head_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return MessageProtobuf.internal_static_Head_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            Head.class, Builder.class);
        }

        public static final int MSGID_FIELD_NUMBER = 1;
        private volatile Object msgId_;
        /**
         * <pre>
         * ��Ϣid
         * </pre>
         *
         * <code>string msgId = 1;</code>
         */
        public String getMsgId() {
            Object ref = msgId_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                msgId_ = s;
                return s;
            }
        }
        /**
         * <pre>
         * ��Ϣid
         * </pre>
         *
         * <code>string msgId = 1;</code>
         */
        public com.google.protobuf.ByteString
        getMsgIdBytes() {
            Object ref = msgId_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (String) ref);
                msgId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int MSGTYPE_FIELD_NUMBER = 2;
        private int msgType_;
        /**
         * <pre>
         * ��Ϣ����
         * </pre>
         *
         * <code>int32 msgType = 2;</code>
         */
        public int getMsgType() {
            return msgType_;
        }

        public static final int MSGCONTENTTYPE_FIELD_NUMBER = 3;
        private int msgContentType_;
        /**
         * <pre>
         * ��Ϣ��������
         * </pre>
         *
         * <code>int32 msgContentType = 3;</code>
         */
        public int getMsgContentType() {
            return msgContentType_;
        }

        public static final int FROMID_FIELD_NUMBER = 4;
        private volatile Object fromId_;
        /**
         * <pre>
         * ��Ϣ������id
         * </pre>
         *
         * <code>string fromId = 4;</code>
         */
        public String getFromId() {
            Object ref = fromId_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                fromId_ = s;
                return s;
            }
        }
        /**
         * <pre>
         * ��Ϣ������id
         * </pre>
         *
         * <code>string fromId = 4;</code>
         */
        public com.google.protobuf.ByteString
        getFromIdBytes() {
            Object ref = fromId_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (String) ref);
                fromId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int TOID_FIELD_NUMBER = 5;
        private volatile Object toId_;
        /**
         * <pre>
         * ��Ϣ������id
         * </pre>
         *
         * <code>string toId = 5;</code>
         */
        public String getToId() {
            Object ref = toId_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                toId_ = s;
                return s;
            }
        }
        /**
         * <pre>
         * ��Ϣ������id
         * </pre>
         *
         * <code>string toId = 5;</code>
         */
        public com.google.protobuf.ByteString
        getToIdBytes() {
            Object ref = toId_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (String) ref);
                toId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int TIMESTAMP_FIELD_NUMBER = 6;
        private long timestamp_;
        /**
         * <pre>
         * ��Ϣʱ���
         * </pre>
         *
         * <code>int64 timestamp = 6;</code>
         */
        public long getTimestamp() {
            return timestamp_;
        }

        public static final int STATUSREPORT_FIELD_NUMBER = 7;
        private int statusReport_;
        /**
         * <pre>
         * ״̬����
         * </pre>
         *
         * <code>int32 statusReport = 7;</code>
         */
        public int getStatusReport() {
            return statusReport_;
        }

        public static final int EXTEND_FIELD_NUMBER = 8;
        private volatile Object extend_;
        /**
         * <pre>
         * ��չ�ֶΣ���key/value��ʽ��ŵ�json
         * </pre>
         *
         * <code>string extend = 8;</code>
         */
        public String getExtend() {
            Object ref = extend_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                extend_ = s;
                return s;
            }
        }
        /**
         * <pre>
         * ��չ�ֶΣ���key/value��ʽ��ŵ�json
         * </pre>
         *
         * <code>string extend = 8;</code>
         */
        public com.google.protobuf.ByteString
        getExtendBytes() {
            Object ref = extend_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (String) ref);
                extend_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!getMsgIdBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, msgId_);
            }
            if (msgType_ != 0) {
                output.writeInt32(2, msgType_);
            }
            if (msgContentType_ != 0) {
                output.writeInt32(3, msgContentType_);
            }
            if (!getFromIdBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 4, fromId_);
            }
            if (!getToIdBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 5, toId_);
            }
            if (timestamp_ != 0L) {
                output.writeInt64(6, timestamp_);
            }
            if (statusReport_ != 0) {
                output.writeInt32(7, statusReport_);
            }
            if (!getExtendBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 8, extend_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!getMsgIdBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, msgId_);
            }
            if (msgType_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(2, msgType_);
            }
            if (msgContentType_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(3, msgContentType_);
            }
            if (!getFromIdBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, fromId_);
            }
            if (!getToIdBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, toId_);
            }
            if (timestamp_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(6, timestamp_);
            }
            if (statusReport_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(7, statusReport_);
            }
            if (!getExtendBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, extend_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Head)) {
                return super.equals(obj);
            }
            Head other = (Head) obj;

            boolean result = true;
            result = result && getMsgId()
                    .equals(other.getMsgId());
            result = result && (getMsgType()
                    == other.getMsgType());
            result = result && (getMsgContentType()
                    == other.getMsgContentType());
            result = result && getFromId()
                    .equals(other.getFromId());
            result = result && getToId()
                    .equals(other.getToId());
            result = result && (getTimestamp()
                    == other.getTimestamp());
            result = result && (getStatusReport()
                    == other.getStatusReport());
            result = result && getExtend()
                    .equals(other.getExtend());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + MSGID_FIELD_NUMBER;
            hash = (53 * hash) + getMsgId().hashCode();
            hash = (37 * hash) + MSGTYPE_FIELD_NUMBER;
            hash = (53 * hash) + getMsgType();
            hash = (37 * hash) + MSGCONTENTTYPE_FIELD_NUMBER;
            hash = (53 * hash) + getMsgContentType();
            hash = (37 * hash) + FROMID_FIELD_NUMBER;
            hash = (53 * hash) + getFromId().hashCode();
            hash = (37 * hash) + TOID_FIELD_NUMBER;
            hash = (53 * hash) + getToId().hashCode();
            hash = (37 * hash) + TIMESTAMP_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getTimestamp());
            hash = (37 * hash) + STATUSREPORT_FIELD_NUMBER;
            hash = (53 * hash) + getStatusReport();
            hash = (37 * hash) + EXTEND_FIELD_NUMBER;
            hash = (53 * hash) + getExtend().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static Head parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static Head parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static Head parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static Head parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static Head parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static Head parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static Head parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static Head parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static Head parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static Head parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static Head parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static Head parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(Head prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code Head}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:Head)
                HeadOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return MessageProtobuf.internal_static_Head_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return MessageProtobuf.internal_static_Head_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                Head.class, Builder.class);
            }

            // Construct using com.freddy.im.protobuf.MessageProtobuf.Head.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                msgId_ = "";

                msgType_ = 0;

                msgContentType_ = 0;

                fromId_ = "";

                toId_ = "";

                timestamp_ = 0L;

                statusReport_ = 0;

                extend_ = "";

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return MessageProtobuf.internal_static_Head_descriptor;
            }

            public Head getDefaultInstanceForType() {
                return Head.getDefaultInstance();
            }

            public Head build() {
                Head result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public Head buildPartial() {
                Head result = new Head(this);
                result.msgId_ = msgId_;
                result.msgType_ = msgType_;
                result.msgContentType_ = msgContentType_;
                result.fromId_ = fromId_;
                result.toId_ = toId_;
                result.timestamp_ = timestamp_;
                result.statusReport_ = statusReport_;
                result.extend_ = extend_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof Head) {
                    return mergeFrom((Head)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(Head other) {
                if (other == Head.getDefaultInstance()) return this;
                if (!other.getMsgId().isEmpty()) {
                    msgId_ = other.msgId_;
                    onChanged();
                }
                if (other.getMsgType() != 0) {
                    setMsgType(other.getMsgType());
                }
                if (other.getMsgContentType() != 0) {
                    setMsgContentType(other.getMsgContentType());
                }
                if (!other.getFromId().isEmpty()) {
                    fromId_ = other.fromId_;
                    onChanged();
                }
                if (!other.getToId().isEmpty()) {
                    toId_ = other.toId_;
                    onChanged();
                }
                if (other.getTimestamp() != 0L) {
                    setTimestamp(other.getTimestamp());
                }
                if (other.getStatusReport() != 0) {
                    setStatusReport(other.getStatusReport());
                }
                if (!other.getExtend().isEmpty()) {
                    extend_ = other.extend_;
                    onChanged();
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                Head parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (Head) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private Object msgId_ = "";
            /**
             * <pre>
             * ��Ϣid
             * </pre>
             *
             * <code>string msgId = 1;</code>
             */
            public String getMsgId() {
                Object ref = msgId_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    msgId_ = s;
                    return s;
                } else {
                    return (String) ref;
                }
            }
            /**
             * <pre>
             * ��Ϣid
             * </pre>
             *
             * <code>string msgId = 1;</code>
             */
            public com.google.protobuf.ByteString
            getMsgIdBytes() {
                Object ref = msgId_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (String) ref);
                    msgId_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <pre>
             * ��Ϣid
             * </pre>
             *
             * <code>string msgId = 1;</code>
             */
            public Builder setMsgId(
                    String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                msgId_ = value;
                onChanged();
                return this;
            }
            /**
             * <pre>
             * ��Ϣid
             * </pre>
             *
             * <code>string msgId = 1;</code>
             */
            public Builder clearMsgId() {

                msgId_ = getDefaultInstance().getMsgId();
                onChanged();
                return this;
            }
            /**
             * <pre>
             * ��Ϣid
             * </pre>
             *
             * <code>string msgId = 1;</code>
             */
            public Builder setMsgIdBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                msgId_ = value;
                onChanged();
                return this;
            }

            private int msgType_ ;
            /**
             * <pre>
             * ��Ϣ����
             * </pre>
             *
             * <code>int32 msgType = 2;</code>
             */
            public int getMsgType() {
                return msgType_;
            }
            /**
             * <pre>
             * ��Ϣ����
             * </pre>
             *
             * <code>int32 msgType = 2;</code>
             */
            public Builder setMsgType(int value) {

                msgType_ = value;
                onChanged();
                return this;
            }
            /**
             * <pre>
             * ��Ϣ����
             * </pre>
             *
             * <code>int32 msgType = 2;</code>
             */
            public Builder clearMsgType() {

                msgType_ = 0;
                onChanged();
                return this;
            }

            private int msgContentType_ ;
            /**
             * <pre>
             * ��Ϣ��������
             * </pre>
             *
             * <code>int32 msgContentType = 3;</code>
             */
            public int getMsgContentType() {
                return msgContentType_;
            }
            /**
             * <pre>
             * ��Ϣ��������
             * </pre>
             *
             * <code>int32 msgContentType = 3;</code>
             */
            public Builder setMsgContentType(int value) {

                msgContentType_ = value;
                onChanged();
                return this;
            }
            /**
             * <pre>
             * ��Ϣ��������
             * </pre>
             *
             * <code>int32 msgContentType = 3;</code>
             */
            public Builder clearMsgContentType() {

                msgContentType_ = 0;
                onChanged();
                return this;
            }

            private Object fromId_ = "";
            /**
             * <pre>
             * ��Ϣ������id
             * </pre>
             *
             * <code>string fromId = 4;</code>
             */
            public String getFromId() {
                Object ref = fromId_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    fromId_ = s;
                    return s;
                } else {
                    return (String) ref;
                }
            }
            /**
             * <pre>
             * ��Ϣ������id
             * </pre>
             *
             * <code>string fromId = 4;</code>
             */
            public com.google.protobuf.ByteString
            getFromIdBytes() {
                Object ref = fromId_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (String) ref);
                    fromId_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <pre>
             * ��Ϣ������id
             * </pre>
             *
             * <code>string fromId = 4;</code>
             */
            public Builder setFromId(
                    String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                fromId_ = value;
                onChanged();
                return this;
            }
            /**
             * <pre>
             * ��Ϣ������id
             * </pre>
             *
             * <code>string fromId = 4;</code>
             */
            public Builder clearFromId() {

                fromId_ = getDefaultInstance().getFromId();
                onChanged();
                return this;
            }
            /**
             * <pre>
             * ��Ϣ������id
             * </pre>
             *
             * <code>string fromId = 4;</code>
             */
            public Builder setFromIdBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                fromId_ = value;
                onChanged();
                return this;
            }

            private Object toId_ = "";
            /**
             * <pre>
             * ��Ϣ������id
             * </pre>
             *
             * <code>string toId = 5;</code>
             */
            public String getToId() {
                Object ref = toId_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    toId_ = s;
                    return s;
                } else {
                    return (String) ref;
                }
            }
            /**
             * <pre>
             * ��Ϣ������id
             * </pre>
             *
             * <code>string toId = 5;</code>
             */
            public com.google.protobuf.ByteString
            getToIdBytes() {
                Object ref = toId_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (String) ref);
                    toId_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <pre>
             * ��Ϣ������id
             * </pre>
             *
             * <code>string toId = 5;</code>
             */
            public Builder setToId(
                    String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                toId_ = value;
                onChanged();
                return this;
            }
            /**
             * <pre>
             * ��Ϣ������id
             * </pre>
             *
             * <code>string toId = 5;</code>
             */
            public Builder clearToId() {

                toId_ = getDefaultInstance().getToId();
                onChanged();
                return this;
            }
            /**
             * <pre>
             * ��Ϣ������id
             * </pre>
             *
             * <code>string toId = 5;</code>
             */
            public Builder setToIdBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                toId_ = value;
                onChanged();
                return this;
            }

            private long timestamp_ ;
            /**
             * <pre>
             * ��Ϣʱ���
             * </pre>
             *
             * <code>int64 timestamp = 6;</code>
             */
            public long getTimestamp() {
                return timestamp_;
            }
            /**
             * <pre>
             * ��Ϣʱ���
             * </pre>
             *
             * <code>int64 timestamp = 6;</code>
             */
            public Builder setTimestamp(long value) {

                timestamp_ = value;
                onChanged();
                return this;
            }
            /**
             * <pre>
             * ��Ϣʱ���
             * </pre>
             *
             * <code>int64 timestamp = 6;</code>
             */
            public Builder clearTimestamp() {

                timestamp_ = 0L;
                onChanged();
                return this;
            }

            private int statusReport_ ;
            /**
             * <pre>
             * ״̬����
             * </pre>
             *
             * <code>int32 statusReport = 7;</code>
             */
            public int getStatusReport() {
                return statusReport_;
            }
            /**
             * <pre>
             * ״̬����
             * </pre>
             *
             * <code>int32 statusReport = 7;</code>
             */
            public Builder setStatusReport(int value) {

                statusReport_ = value;
                onChanged();
                return this;
            }
            /**
             * <pre>
             * ״̬����
             * </pre>
             *
             * <code>int32 statusReport = 7;</code>
             */
            public Builder clearStatusReport() {

                statusReport_ = 0;
                onChanged();
                return this;
            }

            private Object extend_ = "";
            /**
             * <pre>
             * ��չ�ֶΣ���key/value��ʽ��ŵ�json
             * </pre>
             *
             * <code>string extend = 8;</code>
             */
            public String getExtend() {
                Object ref = extend_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    extend_ = s;
                    return s;
                } else {
                    return (String) ref;
                }
            }
            /**
             * <pre>
             * ��չ�ֶΣ���key/value��ʽ��ŵ�json
             * </pre>
             *
             * <code>string extend = 8;</code>
             */
            public com.google.protobuf.ByteString
            getExtendBytes() {
                Object ref = extend_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (String) ref);
                    extend_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <pre>
             * ��չ�ֶΣ���key/value��ʽ��ŵ�json
             * </pre>
             *
             * <code>string extend = 8;</code>
             */
            public Builder setExtend(
                    String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                extend_ = value;
                onChanged();
                return this;
            }
            /**
             * <pre>
             * ��չ�ֶΣ���key/value��ʽ��ŵ�json
             * </pre>
             *
             * <code>string extend = 8;</code>
             */
            public Builder clearExtend() {

                extend_ = getDefaultInstance().getExtend();
                onChanged();
                return this;
            }
            /**
             * <pre>
             * ��չ�ֶΣ���key/value��ʽ��ŵ�json
             * </pre>
             *
             * <code>string extend = 8;</code>
             */
            public Builder setExtendBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                extend_ = value;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:Head)
        }

        // @@protoc_insertion_point(class_scope:Head)
        private static final Head DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new Head();
        }

        public static Head getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<Head>
                PARSER = new com.google.protobuf.AbstractParser<Head>() {
            public Head parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new Head(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<Head> parser() {
            return PARSER;
        }

        @Override
        public com.google.protobuf.Parser<Head> getParserForType() {
            return PARSER;
        }

        public Head getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_Msg_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_Msg_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_Head_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_Head_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }
    private static  com.google.protobuf.Descriptors.FileDescriptor
            descriptor;
    static {
        String[] descriptorData = {
                "\n\tmsg.proto\"(\n\003Msg\022\023\n\004head\030\001 \001(\0132\005.Head\022" +
                        "\014\n\004body\030\002 \001(\t\"\225\001\n\004Head\022\r\n\005msgId\030\001 \001(\t\022\017\n" +
                        "\007msgType\030\002 \001(\005\022\026\n\016msgContentType\030\003 \001(\005\022\016" +
                        "\n\006fromId\030\004 \001(\t\022\014\n\004toId\030\005 \001(\t\022\021\n\ttimestam" +
                        "p\030\006 \001(\003\022\024\n\014statusReport\030\007 \001(\005\022\016\n\006extend\030" +
                        "\010 \001(\tB)\n\026com.freddy.im.protobufB\017Message" +
                        "Protobufb\006proto3"
        };
        com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
                new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
                    public com.google.protobuf.ExtensionRegistry assignDescriptors(
                            com.google.protobuf.Descriptors.FileDescriptor root) {
                        descriptor = root;
                        return null;
                    }
                };
        com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[] {
                        }, assigner);
        internal_static_Msg_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_Msg_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_Msg_descriptor,
                new String[] { "Head", "Body", });
        internal_static_Head_descriptor =
                getDescriptor().getMessageTypes().get(1);
        internal_static_Head_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_Head_descriptor,
                new String[] { "MsgId", "MsgType", "MsgContentType", "FromId", "ToId", "Timestamp", "StatusReport", "Extend", });
    }

    // @@protoc_insertion_point(outer_class_scope)
}