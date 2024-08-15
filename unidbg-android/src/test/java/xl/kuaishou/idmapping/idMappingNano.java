package xl.kuaishou.idmapping;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

import java.io.IOException;

public class idMappingNano extends MessageNano {
    /* renamed from: p */
    public static volatile idMappingNano[] f295710p;

    /* renamed from: a */
    public String a = "";

    /* renamed from: b */
    public String b = "";

    /* renamed from: c */
    public String c = "";

    /* renamed from: d */
    public String d = "";

    /* renamed from: e */
    public String e = "";

    /* renamed from: f */
    public String f = "";

    /* renamed from: g */
    public String g = "";

    /* renamed from: h */
    public String h = "";

    /* renamed from: i */
    public String i = "";

    /* renamed from: j */
    public String j = "";

    /* renamed from: k */
    public String k = "";

    /* renamed from: l */
    public String l = "";

    /* renamed from: m */
    public String m = "";

    /* renamed from: n */
    public String n = "";

    /* renamed from: o */
    public long o = 0;

    public idMappingNano() {
        this.cachedSize = -1;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.a);
        }
        if (!this.b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
        }
        if (!this.c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.c);
        }
        if (!this.d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.d);
        }
        if (!this.e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.e);
        }
        if (!this.f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f);
        }
        if (!this.g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.g);
        }
        if (!this.h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.h);
        }
        if (!this.i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.i);
        }
        if (!this.j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.j);
        }
        if (!this.k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.k);
        }
        if (!this.l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.l);
        }
        if (!this.m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.m);
        }
        if (!this.n.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.n);
        }
        long j = this.o;
        if (j != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(15, j);
        }
        System.out.println(computeSerializedSize);
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    this.a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.k = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.l = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.m = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.n = codedInputByteBufferNano.readString();
                    break;
                case 120:
                    this.o = codedInputByteBufferNano.readInt64();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                        break;
                    } else {
                        break;
                    }
            }
        }
    }

    @Override // com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.a);
        }
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.b);
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.c);
        }
        if (!this.d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.d);
        }
        if (!this.e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.e);
        }
        if (!this.f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f);
        }
        if (!this.g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.g);
        }
        if (!this.h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.h);
        }
        if (!this.i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.i);
        }
        if (!this.j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.j);
        }
        if (!this.k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.k);
        }
        if (!this.l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.l);
        }
        if (!this.m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.m);
        }
        if (!this.n.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.n);
        }
        long j = this.o;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(15, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}

