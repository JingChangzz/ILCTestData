/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/apple/programs/as_code/ILCTestData/aidlserver/src/main/aidl/com/viii/aidlclient/MessageCenter.aidl
 */
package com.viii.aidlclient;
public interface MessageCenter extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements MessageCenter
{
private static final String DESCRIPTOR = "com.viii.aidlclient.MessageCenter";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.viii.aidlclient.MessageCenter interface,
 * generating a proxy if needed.
 */
public static MessageCenter asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof MessageCenter))) {
return ((MessageCenter)iin);
}
return new Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getInfo:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<Info> _result = this.getInfo();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_addInfo:
{
data.enforceInterface(DESCRIPTOR);
Info _arg0;
if ((0!=data.readInt())) {
_arg0 = Info.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
Info _result = this.addInfo(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements MessageCenter
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
//所有的返回值前都不需要加任何东西，不管是什么数据类型

@Override public java.util.List<Info> getInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<Info> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getInfo, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(Info.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
//传参时除了Java基本类型以及String，CharSequence之外的类型
//都需要在前面加上定向tag，具体加什么量需而定

@Override public Info addInfo(Info info) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
Info _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((info!=null)) {
_data.writeInt(1);
info.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = Info.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
info.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_addInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
//所有的返回值前都不需要加任何东西，不管是什么数据类型

public java.util.List<Info> getInfo() throws android.os.RemoteException;
//传参时除了Java基本类型以及String，CharSequence之外的类型
//都需要在前面加上定向tag，具体加什么量需而定

public Info addInfo(Info info) throws android.os.RemoteException;
}
