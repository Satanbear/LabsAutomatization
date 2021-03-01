import { AppPage } from './app.po';
import { browser, by, element, protractor } from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;
  const EC = protractor.ExpectedConditions;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should display main structure', async () => {
    await page.navigateTo();

    await browser.wait(EC.presenceOf(element(by.id('grid'))));
    await browser.wait(EC.presenceOf(element(by.id('addButton'))));
  });

  it('should open add page', async () => {
    await element(by.id('addButton')).click();
    await browser.wait(EC.presenceOf(element(by.id('addForm'))));
  });

  it('should create product', async () => {
    const buttonAddSubmit = element(by.id('addButtonOnAddForm'));
    const buttonAllProductView = element(by.id('allProductView'));

    element(by.id('nameProduct')).sendKeys('TestProductName');
    element(by.id('purchasePrice')).sendKeys('1');
    element(by.id('amount')).sendKeys('1');
    element(by.id('markup')).sendKeys('1');
    element(by.id('shelfLife')).sendKeys('2020-08-20');

    browser.wait(EC.elementToBeClickable(buttonAddSubmit));
    buttonAddSubmit.click();

    browser.wait(EC.elementToBeClickable(buttonAllProductView));
    buttonAllProductView.click();
    buttonAllProductView.click();
  });

  it('should filter grid', async () => {
    // await page.navigateTo();
    const buttonApplyFilter = element(by.id('buttonApplyFilters'));
    element(by.id('name')).sendKeys('TestProductName');
    browser.wait(EC.elementToBeClickable(buttonApplyFilter));
    buttonApplyFilter.click();

    expect(element.all(by.css('table tbody tr')).count()).toBeGreaterThan(1);
  });

  it('should delete product', async () => {
    const buttonApplyFilter = element(by.id('buttonApplyFilters'));
    const buttonDelete = element(by.id('buttonDelete'));

    browser.wait(EC.elementToBeClickable(buttonDelete));
    buttonDelete.click();

    element(by.id('name')).sendKeys('TestProductName');
    browser.wait(EC.elementToBeClickable(buttonApplyFilter));
    buttonApplyFilter.click();

    expect(element.all(by.css('table tbody tr')).count()).toBeGreaterThan(0);
  });
});
