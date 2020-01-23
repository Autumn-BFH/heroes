package ch.bfh.autumn.promoter.service;

import ch.bfh.autumn.promoter.model.Party;

public interface PromoterService {

  String promoteFight();

  String promoteFight(Party challenger, Party challengee);
}
