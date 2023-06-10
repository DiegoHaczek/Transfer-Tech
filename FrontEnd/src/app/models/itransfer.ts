export interface ITransfer {
  movementId?: number;
  transferCode?: number;
  userName?: string;
  accountId?: number;
  type?: string;
  description: string;
  dateTime?: string;
  amount: number;
  receiverAccountId: string;
}
