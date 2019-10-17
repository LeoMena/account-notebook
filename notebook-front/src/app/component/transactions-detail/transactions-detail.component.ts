import { Component, OnInit } from '@angular/core';
import { NotebookService } from 'src/app/service/notebook.service';
import { Transaction } from 'src/app/model/Transaction.model';

@Component({
  selector: 'transactions-detail',
  templateUrl: './transactions-detail.component.html',
  styleUrls: ['./transactions-detail.component.scss']
})
export class TransactionsDetailComponent implements OnInit {

  transactions: Transaction[] = [];

  constructor(private notebookService : NotebookService) { }

  ngOnInit() {
    this.notebookService.getTransactions().subscribe(transactions => {
      this.transactions = transactions;
    })
  }

}
